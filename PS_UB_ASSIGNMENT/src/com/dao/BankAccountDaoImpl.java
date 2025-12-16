package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.utility.UtilityTest.getConnection; // Assuming UtilityTest has the getConnection method

public class BankAccountDaoImpl implements IBankAccountDAO {
	
	// state
	private Connection con;
	private PreparedStatement psDebit;
	private PreparedStatement psCredit;
	
	// SQL Queries for fund transfer (Debit and Credit)
	private static final String SQL_DEBIT = "UPDATE bankaccounts SET balance = balance - ? WHERE id = ?";
	private static final String SQL_CREDIT = "UPDATE bankaccounts SET balance = balance + ? WHERE id = ?";
	
	/**
	 * Initializes the connection and PreparedStatements.
	 * Sets the connection to manual commit mode for transaction management.
	 */
	public BankAccountDaoImpl() throws SQLException {
		// 1. Get the connection
		con = getConnection();
		
		// 2. Set auto-commit to false to begin transaction management
        // All subsequent DML operations will not be committed until con.commit() is called.
		con.setAutoCommit(false); 
		
		// 3. Prepare the statements
		psDebit = con.prepareStatement(SQL_DEBIT);
		psCredit = con.prepareStatement(SQL_CREDIT);
	}

	@Override
	public String transfer_fund(int srcID, int desId, double amt) throws SQLException {
		// --- Transaction Start ---
		try {
			// 1. DEBIT (Source Account)
			psDebit.setDouble(1, amt); 
			psDebit.setInt(2, srcID);
			psDebit.addBatch(); // Add the debit operation to the batch
			
			// 2. CREDIT (Destination Account)
			psCredit.setDouble(1, amt);
			psCredit.setInt(2, desId);
			psCredit.addBatch(); // Add the credit operation to the batch
			
			// Note: We are using two separate PreparedStatements, 
			// so we execute them separately to see the individual results.
			// executeBatch() returns an array of update counts.
			
			// Execute the batch for the DEBIT operation
			int[] debitResult = psDebit.executeBatch();
			
			// Execute the batch for the CREDIT operation
			int[] creditResult = psCredit.executeBatch();
			
			// Check if both updates were successful (i.e., updated exactly 1 row)
			if (debitResult.length == 1 && debitResult[0] == 1 && 
			    creditResult.length == 1 && creditResult[0] == 1) {
				
				// 3. Both updates successful: COMMIT the transaction
				con.commit(); 
				return "Funds transferred successfully! Transaction committed.";
			} else {
				// 4. One or both updates failed (e.g., source ID or dest ID didn't exist)
				// ROLLBACK the transaction
				con.rollback(); 
				return "Funds transfer failed (Account ID error or other issue). Transaction rolled back.";
			}
			
		} catch (SQLException e) {
			// 5. An exception occurred (e.g., not enough balance, database error)
			// ROLLBACK the transaction
			con.rollback();
			// Re-throw the exception to inform the caller
			throw new SQLException("Funds transfer failed due to: " + e.getMessage() + ". Transaction rolled back.");
		}
		// --- Transaction End ---
	}
	
	/**
	 * Closes the PreparedStatements and the Connection.
	 */
	public void close() throws SQLException {
		// IMPORTANT: Reset auto-commit mode before closing (optional but good practice)
		if (con != null) {
			con.setAutoCommit(true);
		}
		
		if (psDebit != null) {
			psDebit.close();
		}
		if (psCredit != null) {
			psCredit.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.utility.UtilityTest.getConnection; 

public class BankAccountDaoImpl implements IBankAccountDAO {
	
	// state
	private Connection con;
	private PreparedStatement psDebit;
	private PreparedStatement psCredit;
	
	// FIX: Use table 'acc', balance column 'bal', and ID column 'accid'
	 String SQL_DEBIT = "UPDATE acc SET bal = bal - ? WHERE accid = ?";
	 String SQL_CREDIT = "UPDATE acc SET bal = bal + ? WHERE accid = ?";
	
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
			psDebit.addBatch(); 
			
			// 2. CREDIT (Destination Account)
			psCredit.setDouble(1, amt);
			psCredit.setInt(2, desId);
			psCredit.addBatch(); 
			
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
			// 5. An exception occurred (e.g., not enough balance, data type error)
			// ROLLBACK the transaction
			con.rollback();
			// Re-throw the exception to inform the caller
			throw new SQLException("Funds transfer failed due to: " + e.getMessage() + ". Transaction rolled back.");
		}
		// --- Transaction End ---
	}
	
	/**
	 * Closes the PreparedStatements and the Connection.
	 * Also resets auto-commit mode to true.
	 */
	public void close() throws SQLException {
		// IMPORTANT: Reset auto-commit mode before closing
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
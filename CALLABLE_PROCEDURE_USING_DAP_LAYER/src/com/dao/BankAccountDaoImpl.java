package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static com.utility.UtilityTest.getConnection;

public class BankAccountDaoImpl implements IBankAccountDAO {
	
	//state
	private Connection con;
	private CallableStatement cs;
	
	//logic for executing eacatly once
	public BankAccountDaoImpl() throws SQLException {
		
		con=getConnection();
		// prepare sql query
		String sql ="{call transfer_fund(?,?,?,?,?)}";
		cs = con.prepareCall(sql);
		//register OUT params
		cs.registerOutParameter(4, Types.DOUBLE); // STATIC FINAL CONSTANT
		cs.registerOutParameter(5, Types.DOUBLE); // STATIC FINAL CONSTANT
	}

	@Override
	public String transfer_fund(int srcID, int desId, double amt) throws SQLException {
	// set IN params values
		cs.setInt(1, srcID);
		cs.setInt(2, desId);
		cs.setDouble(3, amt);
		
		//execute stored procedure
		cs.execute();
		StringBuilder sb = new StringBuilder("Funds transfer..."); 
		sb.append("Updated src balance " + cs.getDouble(4));
		sb.append("Updated dest balance " + cs.getDouble(5));
		return sb.toString();
		
	}
	public void close() throws SQLException {
		if(cs!=null) {
			cs.close();
		}
		if(con!=null) {
			con.close();
		}
	}

}

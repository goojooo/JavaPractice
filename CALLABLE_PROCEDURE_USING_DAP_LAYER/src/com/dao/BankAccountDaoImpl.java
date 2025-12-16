package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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
	}

	@Override
	public String transfer_fund(int srcID, int desId, double amt) throws SQLException {
	
		
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

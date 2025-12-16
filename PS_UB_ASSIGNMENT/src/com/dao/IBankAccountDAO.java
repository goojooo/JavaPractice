package com.dao;

import java.sql.SQLException;

public interface IBankAccountDAO {
	String transfer_fund(int srcID, int desId, double amt)throws SQLException;

}

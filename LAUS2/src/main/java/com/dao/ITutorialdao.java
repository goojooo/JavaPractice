package com.dao;

import java.sql.SQLException;
import java.util.List;

public interface ITutorialdao {
	List<String> getAllTopics() throws SQLException;
}

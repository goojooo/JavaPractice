package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.T;

public interface DAO<T> {
	T get(int student_id) throws SQLException;
	
	List<T> getAll() throws SQLException;
	
	int save(T t) throws SQLException;
	
	int insert(T t) throws SQLException;
	
	int update(T t) throws SQLException;
	
	int delete(T t);
}

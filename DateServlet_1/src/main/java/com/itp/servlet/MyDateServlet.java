package com.itp.servlet;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyDateServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date d = new Date(); //service date and time
		System.out.println(d);
		
	}

}

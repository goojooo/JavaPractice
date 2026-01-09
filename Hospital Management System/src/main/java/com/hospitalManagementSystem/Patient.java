package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
	private Connection con;
	private Scanner sc;
	
	public Patient(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
	}
	
	public void addPatient() {
		System.out.println("Enter patient name : ");
		String name = sc.next();
		
		System.out.println("Enter patient age : ");
		int age = sc.nextInt();
		
		System.out.println("Enter patient gender : ");
		String gender = sc.next();
		
		try
		{
			String query = "insert into patients (name , age, gender ) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows > 0) {
				System.out.println("Patient added successfully...!");
			} else {
				System.out.println("Patient added Failed...!!");
			}
			
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void viewPatients() {
		String query ="select * from patients";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);	
			ResultSet rs = ps.executeQuery();
			System.out.println("Patients : ");
			System.out.println("+-------------+----------------+-----------+----------------+");
			System.out.println("| Patients Id | Name           | Age       | Gender         |");
			System.out.println("+-------------+----------------+-----------+----------------+");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				System.out.printf("|%-13s|%-20s|%-11s|%-16s| \n ", id , name, age , gender);
				System.out.println("+-------------+----------------+-----------+----------------+");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getPatientById(int id)
	{
		String query = "select * from patients where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

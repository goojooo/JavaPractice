package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {
	private static final String url = "jdbc:mysql://localhost:3306/hospital";
	private static final String username = "root";
	private static final String password = "gojo";
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Patient pt = new Patient(con, sc );
			Doctor doc = new Doctor(con);
			
			while(true) {
				System.out.println("HOSPITAL MANAGEMENT SYSTEM : ");
				System.out.println("1. Add Patients");
				System.out.println("2. View Patients");
				System.out.println("3. View Doctors");
				System.out.println("4. Book Appointment");
				System.out.println("5. EXIT");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1 :
					// Add patients
					pt.addPatient();
					System.out.println();
					break;
					
				case 2 :
					// View patient
					pt.viewPatients();
					System.out.println();
					break;
					
				case 3 :
					// View doctors
					doc.viewDoctors();
					System.out.println();
					break;
					
				case 4 :
					// Book appointmenet
					bookAppointment(pt, doc, con, sc);
					System.out.println();
					break;
					
					
				case 5 :
					//Exit
					System.out.println();
					return ;
					
				default :
					System.out.println("<<<Enter valid choice>>>");
					break;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void bookAppointment(Patient p, Doctor d, Connection con, Scanner sc) {
		System.out.println("Enter patient id : ");
		int patientId = sc.nextInt();
		
		System.out.println("Enter doctor id : ");
		int docId = sc.nextInt();
		
		System.out.println("Enter appointmnet date : ");
		String appDate = sc.next();
		
		if(p.getPatientById(patientId) && d.getDoctorById(docId)) {
			if(chechDocAvailable(docId,appDate, con)) {
				String appQuery = "insert into appointments(patient_id, doctor_id, appointment_date) values(?,?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(appQuery);
					ps.setInt(1, patientId);
					ps.setInt(2, docId);
					ps.setString(3, appDate);
					
					int rowAffected = ps.executeUpdate();
					if(rowAffected>0) {
						System.out.println("Appointment Book...!");
					} else {
						System.out.println("Failed to book appointment...!");
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Doctor are not available on this date...!");
			}
		} else {
			System.out.println("Eighter Doctor or Patient is doesn't exist...!");
		}
	}
	
	public static boolean chechDocAvailable(int docId, String appDate, Connection con ) {
		String query = "select count(*) from appointments where doctor_id =? and appointment_date = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, docId);
			ps.setString(2, appDate);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}

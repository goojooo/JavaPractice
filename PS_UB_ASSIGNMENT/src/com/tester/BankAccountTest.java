package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.BankAccountDaoImpl;

public class BankAccountTest {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			// Instantiate the DAO, which also sets up the connection and transaction mode
			BankAccountDaoImpl i = new BankAccountDaoImpl();
			
			System.out.println("Enter account details: src accNo, dest accNo, Amt to be transferred...");
			
			// Get input and execute the transfer
			int srcAccNo = sc.nextInt();
			int destAccNo = sc.nextInt();
			double amount = sc.nextDouble();
			
			String msg = i.transfer_fund(srcAccNo, destAccNo, amount);
			
			System.out.println(msg);
			
			// Ensure the connection is closed
			i.close();
			
		} catch (SQLException e) {
			System.err.println("Database Error occurred:");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred:");
			e.printStackTrace();
		}

	}

}
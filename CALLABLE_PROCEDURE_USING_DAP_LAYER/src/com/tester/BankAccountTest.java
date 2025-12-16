package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.BankAccountDaoImpl;

public class BankAccountTest {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			BankAccountDaoImpl i = new BankAccountDaoImpl();
			System.out.println("Enter account details : src accNo, Amt to be transferd...");
			String msg = i.transfer_fund(sc.nextInt(),sc.nextInt(),sc.nextDouble());
			System.out.println(msg);
			i.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

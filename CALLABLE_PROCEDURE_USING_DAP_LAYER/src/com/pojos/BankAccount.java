package com.pojos;

public class BankAccount {
	private int accId;
	private String name;
	private String accType;
	private double balance;
	
	
	public BankAccount(int accId, String name, String accType, double balance) {
		super();
		this.accId = accId;
		this.name = name;
		this.accType = accType;
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", name=" + name + ", accType=" + accType + ", balance=" + balance + "]";
	}
	
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}

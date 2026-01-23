package com.itp.service;

import com.itp.beans.Employee;

public class PaySlipGeneratorService {
	
	public void generatePaySlip(Employee e)
	{
		float grossSalary = e.getBasicSal() + e.getBasicSal() * 0.4f;
		float netSalary = grossSalary - (grossSalary * 0.2f);
		
		e.setGrossSal(grossSalary);
		e.setNetSal(netSalary);
	}

}

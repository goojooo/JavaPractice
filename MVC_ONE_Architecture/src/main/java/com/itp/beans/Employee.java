package com.itp.beans;

public class Employee {
	private String ename;
	private String eadd;
	private float basicSal;
	private float grossSal;
	private float netSal;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public float getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(float basicSal) {
		this.basicSal = basicSal;
	}
	public float getGrossSal() {
		return grossSal;
	}
	public void setGrossSal(float grossSal) {
		this.grossSal = grossSal;
	}
	public float getNetSal() {
		return netSal;
	}
	public void setNetSal(float netSal) {
		this.netSal = netSal;
	}
	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eadd=" + eadd + ", basicSal=" + basicSal + ", grossSal=" + grossSal
				+ ", netSal=" + netSal + "]";
	}
	public Employee(String ename, String eadd, float basicSal, float grossSal, float netSal) {
		super();
		this.ename = ename;
		this.eadd = eadd;
		this.basicSal = basicSal;
		this.grossSal = grossSal;
		this.netSal = netSal;
	}
	

}

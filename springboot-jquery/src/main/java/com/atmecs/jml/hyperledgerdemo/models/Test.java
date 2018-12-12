package com.atmecs.jml.hyperledgerdemo.models;

import java.util.Date;

public class Test {
	private String testName;
	private int expirationInMonths;
	private String $class = "org.atmecs.poc.Test";
	private String status;
	private Date date; 
	private String verifierName; 
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getExpirationInMonths() {
		return expirationInMonths;
	}
	public void setExpirationInMonths(int expirationInMonths) {
		this.expirationInMonths = expirationInMonths;
	}
	
	public String get$class() {
		return $class;
	}
	public void set$class(String $class) {
		this.$class = $class;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVerifierName() {
		return verifierName;
	}
	public void setVerifierName(String verifierName) {
		this.verifierName = verifierName;
	}
	@Override
	public String toString() {
		return "Test [testName=" + testName + ", expirationInMonths=" + expirationInMonths + ", $class=" + $class
				+ ", status=" + status + ", date=" + date + ", verifierName=" + verifierName + "]";
	}
	
	
	
}

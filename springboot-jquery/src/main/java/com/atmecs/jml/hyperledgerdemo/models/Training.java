package com.atmecs.jml.hyperledgerdemo.models;

import java.util.Date;

public class Training {
	private String trainingName;
	private int expirationInMonths;
	private String $class = "org.atmecs.poc.Training";
	private String status;
	private Date date; 
	private String verifierName;
	
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
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
		return "Training [trainingName=" + trainingName + ", expirationInMonths=" + expirationInMonths + ", $class="
				+ $class + ", status=" + status + ", date=" + date + ", verifierName=" + verifierName + "]";
	}
	
			
	
}

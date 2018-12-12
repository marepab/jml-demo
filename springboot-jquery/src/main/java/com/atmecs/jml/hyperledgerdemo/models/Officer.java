package com.atmecs.jml.hyperledgerdemo.models;

import java.util.List;

public class Officer{
	private String officerId;
	private String firstName;
	private String lastName;
	private String roleName;
	private String homeOffice;	
	private Test [] tests;	
	private Training [] trainings;
	private String $class = "org.atmecs.poc.Officer";
	
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public String getHomeOffice() {
		return homeOffice;
	}
	public void setHomeOffice(String homeOffice) {
		this.homeOffice = homeOffice;
	}

	public Test[] getTests() {
		return tests;
	}
	public void setTests(Test[] tests) {
		this.tests = tests;
	}
	public Training[] getTrainings() {
		return trainings;
	}
	public void setTrainings(Training[] trainings) {
		this.trainings = trainings;
	}
	public String get$class() {
		return $class;
	}
	public void set$class(String $class) {
		this.$class = $class;
	}
	@Override
	public String toString() {
		return "Officer [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName + ", roleName="
				+ roleName + ", homeOffice=" + homeOffice + ", tests=" + tests + ", trainings=" + trainings
				+ ", $class=" + $class + "]";
	}
	
	
	
}

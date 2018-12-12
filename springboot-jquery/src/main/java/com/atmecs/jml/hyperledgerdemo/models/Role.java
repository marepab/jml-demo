package com.atmecs.jml.hyperledgerdemo.models;

import java.util.List;

public class Role {
	private String roleName;
	private List<Test> tests;	
	private List<Training> trainings;
	private String $class = "org.atmecs.poc.Role";
		
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	public List<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(List<Training> trainings) {
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
		return "Role [roleName=" + roleName + ", tests=" + tests + ", trainings=" + trainings + "]";
	}
}

package com.atmecs.jml.hyperledgerdemo.models;

public class HomeOffice {

	private String $class = "org.atmecs.poc.HomeOffice";
	private String homeOfficeId;
	private String homeOfficeName;

	public String get$class() {
		return $class;
	}

	public void set$class(String $class) {
		this.$class = $class;
	}

	public String getHomeOfficeId() {
		return homeOfficeId;
	}

	public void setHomeOfficeId(String homeOfficeId) {
		this.homeOfficeId = homeOfficeId;
	}

	public String getHomeOfficeName() {
		return homeOfficeName;
	}

	public void setHomeOfficeName(String homeOfficeName) {
		this.homeOfficeName = homeOfficeName;
	}

}

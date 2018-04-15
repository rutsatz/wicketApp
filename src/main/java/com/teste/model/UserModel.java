package com.teste.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String gender;

	private String pswd;

	public UserModel() {
	}

	public UserModel(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

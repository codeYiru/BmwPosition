package com.vehicle.position.entities;

import org.springframework.stereotype.Component;

@Component
public class VehicleUser {

	private String name;

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VehicleUser() {
	}

	public VehicleUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

}

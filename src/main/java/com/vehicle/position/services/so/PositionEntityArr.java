package com.vehicle.position.services.so;

import org.springframework.stereotype.Component;

import com.vehicle.position.entities.PositionEntity;

@Component
public class PositionEntityArr {

	private PositionEntity[] arr;

	public PositionEntity[] getArr() {
		return arr;
	}

	public void setArr(PositionEntity[] arr) {
		this.arr = arr;
	}

}
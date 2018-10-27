package com.vehicle.position.services.impl;

import org.springframework.stereotype.Service;

import com.vehicle.position.services.api.IProcessService;


@Service
public class ProcessService implements IProcessService {

	@Override
	public int processBySession(String session) {
		return 0;
	}

	@Override
	public int processByVehicle(long vehicleId) {
		return 0;
	}

}

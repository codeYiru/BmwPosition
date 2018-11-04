package com.vehicle.position.services.impl;

import org.springframework.stereotype.Service;

import com.vehicle.position.services.api.IVehicleService;
import com.vehicle.position.services.so.VehicleSessionSo;


@Service
public class VehicleService implements IVehicleService {

	// This part should be done through some authentication service or redis service.
	@Override	
	public long getIdBySession(String session) { // default 1l; for test
		return 1l;
	}

	@Override
	public VehicleSessionSo getSessionInfoBySession(String session) {
		VehicleSessionSo so = new VehicleSessionSo();
		so.setSession(session);

		return so;
	}

}

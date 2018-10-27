package com.vehicle.position.services.impl;

import org.springframework.stereotype.Service;

import com.vehicle.position.services.api.IVehicleService;
import com.vehicle.position.services.so.VehicleSessionSo;

// TODO
@Service
public class VehicleService implements IVehicleService {

	@Override
	public long getIdBySession(String session) {
		return 0;
	}

	@Override
	public VehicleSessionSo getSessionInfoBySession(String session) {
		VehicleSessionSo so = new VehicleSessionSo();
		so.setSession(session);

		return so;
	}

}

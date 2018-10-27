package com.vehicle.position.services.api;

import com.vehicle.position.services.so.VehicleSessionSo;

public interface IVehicleService {

	public long getIdBySession(String session);

	public VehicleSessionSo getSessionInfoBySession(String session);

}

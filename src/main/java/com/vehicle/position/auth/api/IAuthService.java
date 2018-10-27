package com.vehicle.position.auth.api;

import com.vehicle.position.services.so.VehicleSessionSo;

// authenticate service should be in a particular project
public interface IAuthService {

	public static short SUCCESS = 0;

	public static short ERROR = 1;

	public VehicleSessionSo checkSession(String session);
	


}

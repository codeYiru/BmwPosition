package com.vehicle.position.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.position.entities.PositionEntity;
import com.vehicle.position.services.api.ISaveService;
import com.vehicle.position.services.api.IVehicleService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/Save")
public class SaveController {

	@Autowired
	private ISaveService service;

	@Autowired
	private IVehicleService vehicleService;

	public int save(PositionEntity entity) {
		entity.setVehicleId(vehicleService.getIdBySession(entity.getSession()));
		return service.save(entity);
	}

	public int saveBatch(String session, List<PositionEntity> list) {

		long vehicleId = vehicleService.getIdBySession(session);
		list.stream().forEach(entity -> {
			entity.setVehicleId(vehicleId);
		});
		
		return service.saveBatch(list);
	}

}

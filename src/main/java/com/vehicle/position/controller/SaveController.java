package com.vehicle.position.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.position.entities.PositionEntity;
import com.vehicle.position.services.api.ISaveService;
import com.vehicle.position.services.api.IVehicleService;
import com.vehicle.position.services.so.PositionEntityArr;

@RestController
@EnableAutoConfiguration
@RequestMapping("/Save")
public class SaveController {

	@Autowired
	private ISaveService service;

	@Autowired
	private IVehicleService vehicleService;

	@PostMapping("save")
	public int save(@RequestBody PositionEntity entity) {
		if (entity == null) {
			return 0;
		}

		entity.setVehicleId(vehicleService.getIdBySession(entity.getSession()));
		return service.save(entity);
	}



	@PostMapping(name = "saveBatch", produces = "application/json")
	public int saveBatch(@RequestBody PositionEntityArr entityArr) {
		if (entityArr == null || entityArr.getArr().length < 1) {
			return 0;
		}

		List<PositionEntity> list = Arrays.asList(entityArr.getArr());
		Map<String, List<PositionEntity>> sessionMap = list.stream()
				.collect(Collectors.groupingBy(PositionEntity::getSession));

		List<PositionEntity> batchList = new ArrayList<PositionEntity>();

		sessionMap.forEach((k, v) -> {
			long vehicleId = vehicleService.getIdBySession(k);
			v.stream().forEach(entity -> {
				entity.setVehicleId(vehicleId);
			});
			batchList.addAll(v);

		});

		return service.saveBatch(batchList.stream().sorted(Comparator.comparing(PositionEntity::getTimestamp))
				.collect(Collectors.toList()));
	}

}

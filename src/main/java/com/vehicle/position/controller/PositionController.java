package com.vehicle.position.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.position.entities.PositionEntity;
import com.vehicle.position.services.api.IPositionService;

/**
 * <p> Title: [名称]</p>
 * <p> Description: [描述]</p>
 * <p> Created on Oct 24, 2018</p>
 * <p> Copyright: Copyright (c) 2015</p>
 * @author guo.yyrr@hotmail.com
 * @version 1.0
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/Position")
public class PositionController {

	@Autowired
	private IPositionService service;

	@GetMapping("queryByTimestamp")
	public PositionEntity queryByTimestamp(long vechicleId, long timestamp) {
		return service.queryPositionByTimestamp(vechicleId, timestamp);
	}
	@GetMapping("queryListByTime")
	public PositionEntity queryListByTime(long vechicleId, long starttime, long endtime) {
		return service.queryListByTime(vechicleId, starttime, endtime);
	}

	@GetMapping("queryLastPosition")
	public PositionEntity queryLastPosition(long vechicleId) {
		return service.queryLastPosition(vechicleId);
	}

	@GetMapping("queryBySession")
	public List<PositionEntity> queryBySession(String session) {
		return service.queryBySession(session);
	}

	@GetMapping("queryByVehicle")
	public List<PositionEntity> queryAll(long vechicleId) {
		return service.queryAll(vechicleId);
	}

}

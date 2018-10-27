package com.vehicle.position.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.position.entities.PositionEntity;
import com.vehicle.position.repository.PositionRepository;
import com.vehicle.position.services.api.IPositionService;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private PositionRepository repository;

	@Override
	public List<PositionEntity> queryAll(long vehicleId) {
		return repository.queryByVehicleId(vehicleId);
	}

	@Override
	public List<PositionEntity> queryBySession(String session) {
		return repository.queryBySession(session);
	}

	@Override
	public PositionEntity queryLastPosition(long vehicleId) {
		return repository.queryLastPosition(vehicleId);
	}

	@Override
	public PositionEntity queryPositionByTimestamp(long vehicleId, long timestamp) {
		return repository.queryByTimestamp(vehicleId, timestamp);
	}

}

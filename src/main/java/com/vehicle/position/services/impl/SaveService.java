package com.vehicle.position.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.position.entities.PositionEntity;
import com.vehicle.position.repository.PositionRepository;
import com.vehicle.position.services.api.ISaveService;

@Service
public class SaveService implements ISaveService {

	@Autowired
	private PositionRepository repository;

	@Override
	public int save(PositionEntity entity) {
		try {
			repository.save(entity);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return -1;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int saveBatch(List<PositionEntity> entities) {
		try {
			repository.saveAll(entities);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return -1;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

}

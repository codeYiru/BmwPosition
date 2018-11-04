package com.vehicle.position.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vehicle.position.entities.PositionEntity;

// it is possible to remove "order by timestamp" condition, when all data were stored in order.
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

	@Query(value = "select * from vehicle_position where vehicle_id = ?1 ", nativeQuery = true)
	public List<PositionEntity> queryByVehicleId(long vehicleId);

	@Query(value = "select * from vehicle_position where session = ?1 ", nativeQuery = true)
	public List<PositionEntity> queryBySession(String session);

	@Query(value = "select * from vehicle_position where vehicle_id = ?1 and timestamp = ?2", nativeQuery = true)
	public PositionEntity queryByTimestamp(long vehicleId, long timestamp);
	
	
	@Query(value="select * from vehicle_position where vehicle_id = ?1 order by id desc limit 0,1", nativeQuery=true)
	public PositionEntity queryLastPosition(long vehicleId);

	@Query(value="select * from vehicle_position where vehicle_id = ?1 and timestamp between ?2 and ?3 ", nativeQuery=true)
	public PositionEntity queryListByTime(long vehicleId, long starttime, long endtime);
}

/**
 * 文件名：IPositionService.java
 *
 * This service is used for searching data
 *
 * 创建人：guo.yyrr@hotmail.com
 *
 * 创建时间：Oct 24, 2018 8:48:31 PM
 *
 * 版权所有：YIRU
 */
package com.vehicle.position.services.api;

import java.util.List;

import com.vehicle.position.entities.PositionEntity;

public interface IPositionService {
	
	public List<PositionEntity> queryAll(long vechicleId);
	
	public List<PositionEntity> queryBySession(String session);
	
	public PositionEntity queryLastPosition(long vechicleId);
	
	public PositionEntity queryPositionByTimestamp(long vechicleId, long timestamp);

	public PositionEntity queryListByTime(long vechicleId, long starttime, long endtime);

}

/**
 *  文件名：ISaveService.java
 *  
 *  This Service mainly handle the save/persistence services.
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


public interface ISaveService {

	// save one Position interface
	public int save(PositionEntity entity);
	
	// save batch
	public int saveBatch(List<PositionEntity> entity);
	
}

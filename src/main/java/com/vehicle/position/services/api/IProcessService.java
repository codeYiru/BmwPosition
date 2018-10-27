/**
 * 文件名：IProcessService.java
 * 
 * This Service mainly for process stored data
 *
 * 创建人：guo.yyrr@hotmail.com
 *
 * 创建时间：Oct 24, 2018 8:48:31 PM
 *
 * 版权所有：YIRU
 */
package com.vehicle.position.services.api;

public interface IProcessService {

	public int processBySession(String session);

	public int processByVehicle(long vehicleId);

}

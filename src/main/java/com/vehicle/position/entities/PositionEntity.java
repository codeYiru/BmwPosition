package com.vehicle.position.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_position", indexes = { @Index(name = "session_index", columnList = "session", unique = false),
		@Index(name = "vehicle_index", columnList = "vehicle_id", unique = false) })
public class PositionEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(length = 20, nullable = false, name="vehicle_id")
	private long vehicleId;

	@Column(length = 255, nullable = false)
	private String session;

	@Column(length = 20, nullable = false)
	private long timestamp;

	@Column(length = 32, nullable = false)
	private String latitude;

	@Column(length = 32, nullable = false)
	private String longtitude;

	@Column(length = 10, nullable = false)
	private int heading;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

}

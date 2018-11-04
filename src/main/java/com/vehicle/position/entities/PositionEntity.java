package com.vehicle.position.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_position", indexes = { @Index(name = "session_index", columnList = "session", unique = false),
		@Index(name = "vehicle_index", columnList = "vehicle_id", unique = false) })
public class PositionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916099288006705541L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 20, nullable = false, name = "vehicle_id")
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

	public PositionEntity() {
	}

	public PositionEntity(String session, long vehicleId, long timestamp, String latitude, String longtitude,
			int heading) {
		this.session = session;
		this.vehicleId = vehicleId;
		this.timestamp = timestamp;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.heading = heading;
	}

	public String toJsonString() {
		String json = "{";
		List<String> list = new ArrayList<>();

		list.add("\"session\":\"" + this.session + "\"");

		list.add("\"vehicleId\":" + this.vehicleId);

		list.add("\"timestamp\":" + this.timestamp);

		list.add("\"latitude\":" + this.latitude);

		list.add("\"longtitude\":" + this.longtitude);

		list.add("\"heading\":" + this.heading);

		json += String.join(",", list) + "}";

		return json;
	}

}

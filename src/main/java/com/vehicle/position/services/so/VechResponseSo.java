/**
 * 文件名：VechResponseSo.java
 *
 * 创建人：yiru.guo@noboedu.com
 *
 * 创建时间：Oct 24, 2018 8:26:17 PM
 *
 * 版权所有：诺博教育
 */
package com.vehicle.position.services.so;

public class VechResponseSo {

	public static short OK = 0;

	public static short ERROR = 1;

	private short status = OK;

	private String message = "";

	public VechResponseSo() {
	}

	public VechResponseSo(short status, String message) {
		this.status = status;
		this.message = message;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toJsonString() {

		StringBuilder builder = new StringBuilder("{\"status\":" + this.status + ",\"messge\":" + this.message + "}");

		return builder.toString();
	}

}

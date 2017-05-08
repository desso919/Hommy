package com.hommy.administrator.dao.objects;

public class Device {

	private String name;
	private String id;
	private String macAddress;
	
	public Device(String name, String id, String macAddress) {
		this.name = name;
		this.id = id;
		this.macAddress = macAddress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Override
	public String toString() {
		return "Device [name=" + name + ", id=" + id + ", macAddress=" + macAddress + "]";
	}
}

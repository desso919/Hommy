package com.hommy.administrator.dao.objects;

public class Rule {
	
	private String name;
	private String id;
	private Device device;
	private String action;

	
	public Rule(String name, String id, Device device, String action) {
		this.name = name;
		this.id = id;
		this.device = device;
		this.action = action;
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
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Rule [name=" + name + ", id=" + id + ", device=" + device + ", action=" + action + "]";
	}
	
	
}
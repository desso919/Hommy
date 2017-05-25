package com.hommy.administrator.dao.objects;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Device {

	private int id;
	private String name;
	private String macAddress;
	private Protocol protocol;
	private List<Action> actions;

	public Device(int id, String name) {
		this.id = id;
		this.name = name;
		protocol = Protocol.HTTPS;
	}

	public Device(int id, String name, String macAddress) {
		this.id = id;
		this.name = name;
		this.macAddress = macAddress;
	}

	public Device(int id, String name, Protocol protocol) {
		this.id = id;
		this.name = name;
		this.protocol = protocol;
	}

	public Device(int id, String name, Protocol protocol, String macAddress) {
		this.id = id;
		this.name = name;
		this.protocol = protocol;
		this.macAddress = macAddress;
	}

	public Device(int id, String deviceName, List<Action> actions) {
		this.id = id;
		this.name = deviceName;
		this.actions = actions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", macAddress=" + macAddress + ", protocol=" + protocol + "]";
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}

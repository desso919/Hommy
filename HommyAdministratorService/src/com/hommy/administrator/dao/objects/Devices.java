package com.hommy.administrator.dao.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Devices {

	private List<Device> devices;

	public Devices() {
		devices = new ArrayList<Device>();
	}

	public Devices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public boolean addDevice(Device device) {
		if (device != null) {
			devices.add(device);
			return true;
		}
		return false;
	}

	public Device getDevice(int index) {
		return devices.get(index);
	}

	public Device getDevice(String name) {
		for (Device device : devices) {
			if (device.getName().equals(name)) {
				return device;
			}
		}

		return null;
	}

	public boolean containsDeviceWithName(String name) {
		for (Device device : devices) {
			if (device.getName().equals(name)) {
				return true;
			}
		}

		return false;
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}

package com.hommy.service;

import java.util.List;

import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;

public class AllDevicesInNetwork {

	private static Devices devices = new Devices();

	public static List<Device> getDevices() {
		return devices.getDevices();
	}

	public static boolean add(Device device) {
		return devices.addDevice(device);
	}

}

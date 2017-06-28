package com.hommy.service;

import java.util.List;

import com.hommy.administrator.dao.impl.DevicesOperation;
import com.hommy.administrator.dao.interfaces.IDevice;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;
import com.hommy.service.interfaces.IDeviceSubscriber;

public class AllConnectedDevices {

	private static List<IDeviceSubscriber> devices;
	private static IDevice deviceService;

	public AllConnectedDevices() {
		deviceService = new DevicesOperation();
		Devices devicesDB = deviceService.getAllDevice();

		for (Device device : devicesDB.getDevices()) {
			devices.add(DeviceSubscriberFactory.createDevice(device));
		}
	}
}

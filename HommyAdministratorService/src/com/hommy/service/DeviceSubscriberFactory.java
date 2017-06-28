package com.hommy.service;

import com.hommy.administrator.dao.objects.DEVICE_TYPE;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.subscribers.Fridge;
import com.hommy.service.subscribers.Laptop;
import com.hommy.service.subscribers.SmartPhone;
import com.hommy.service.subscribers.TV;

public class DeviceSubscriberFactory {

	public static synchronized IDeviceSubscriber createDevice(Device device) {

		IDeviceSubscriber deviceSubscriber = null;
		String deviceType = device.getDeviceType();

		if (deviceType.equalsIgnoreCase(DEVICE_TYPE.LAPTOP.toString())) {
			deviceSubscriber = new Laptop();
			deviceSubscriber.setDeviceType(DEVICE_TYPE.LAPTOP);
		} else if (deviceType.equalsIgnoreCase(DEVICE_TYPE.SMARTPHONE.toString())) {
			deviceSubscriber = new SmartPhone();
			deviceSubscriber.setDeviceType(DEVICE_TYPE.SMARTPHONE);
		} else if (deviceType.equalsIgnoreCase(DEVICE_TYPE.TV.toString())) {
			deviceSubscriber = new TV();
			deviceSubscriber.setDeviceType(DEVICE_TYPE.TV);
		} else if (deviceType.equalsIgnoreCase(DEVICE_TYPE.FRIDGE.toString())) {
			deviceSubscriber = new Fridge();
			deviceSubscriber.setDeviceType(DEVICE_TYPE.FRIDGE);
		}

		if (deviceSubscriber != null) {
			deviceSubscriber.setId(device.getId());
			deviceSubscriber.setDeviceName(device.getName());
		}
		return deviceSubscriber;
	}
}

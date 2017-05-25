package com.hommy.administrator.dao.interfaces;

import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;

public interface IDevice {

	// TODO add javadoc
	public Devices getAllDevice();

	public Device getDevice(String name);

	public boolean addDevice(Device device);

	public boolean removeDevice(int id);

}

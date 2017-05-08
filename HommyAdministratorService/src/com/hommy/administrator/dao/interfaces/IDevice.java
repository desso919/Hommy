package com.hommy.administrator.dao.interfaces;

import java.util.List;

import com.hommy.administrator.dao.objects.Device;

public interface IDevice {

	public List<Device> getAllDevice();

	public Device getDevice();

	public void addDevice();

	public void removeDevice();

}

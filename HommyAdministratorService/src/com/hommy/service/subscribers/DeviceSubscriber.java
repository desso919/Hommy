package com.hommy.service.subscribers;

import com.hommy.administrator.dao.objects.DEVICE_TYPE;
import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.interfaces.ITopic;

public abstract class DeviceSubscriber implements IDeviceSubscriber {

	private int id;
	private String deviceName;
	private ITopic topic;
	private DEVICE_TYPE deviceType;

	public DeviceSubscriber(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public ITopic getTopic() {
		return topic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setTopic(ITopic topic) {
		this.topic = topic;
	}

	public DEVICE_TYPE getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DEVICE_TYPE deviceType) {
		this.deviceType = deviceType;
	}
}

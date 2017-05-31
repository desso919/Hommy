package com.hommy.service.subscribers;

import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.interfaces.ITopic;

public abstract class DevcieSubscriber implements IDeviceSubscriber {

	private String deviceName;
	private ITopic topic;

	public DevcieSubscriber(String deviceName) {
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

	@Override
	public void setTopic(ITopic topic) {
		this.topic = topic;
	}

}

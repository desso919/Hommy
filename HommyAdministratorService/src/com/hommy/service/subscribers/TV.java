package com.hommy.service.subscribers;

public class TV extends DeviceSubscriber {

	public TV() {
		super("TV");
	}

	@Override
	public void update() {
		String message = (String) super.getTopic().getUpdate(this);
		if (message == null) {
			System.out.println(super.getDeviceName() + ":: No new message");
		} else
			System.out.println(super.getDeviceName() + ":: Consuming message::" + message);
	}
}

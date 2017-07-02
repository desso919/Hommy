package com.hommy.service.subscribers;

import com.hommy.service.Topics;
import com.hommy.utils.HTTPUtil;
import com.hommy.utils.HommyUtil;
import com.hommy.utils.Message;

public class SmartPhone extends DeviceSubscriber {

	public SmartPhone() {
		super("SmartPhone");
	}

	@Override
	public void update() {
		String message = (String) super.getTopic().getUpdate(this);
		if (message == null) {
			System.out.println(super.getDeviceName() + ":: No new message");
		} else {
			System.out.println(super.getDeviceName() + ":: Consuming message from Smartphone::" + message);
			if (message.equalsIgnoreCase(Topics.NOTIFICATION.toString())) {
				Message massageToSend = new Message(HommyUtil.DEVICE_TOKEN);
				massageToSend.add("message", "The Fire alarm was activated");
				boolean isSend = HTTPUtil.sendMessage(massageToSend);
				System.out.println("IS SEND? " + isSend);
			}
		}
	}
}

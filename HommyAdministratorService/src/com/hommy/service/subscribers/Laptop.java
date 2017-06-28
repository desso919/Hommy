package com.hommy.service.subscribers;

public class Laptop extends DeviceSubscriber {

	public Laptop() {
		super("Laptop");
	}

	@Override
	public void update() {
		String message = (String) super.getTopic().getUpdate(this);
		if (message == null) {
			System.out.println(super.getDeviceName() + ":: No new message");
		} else {
			System.out.println(super.getDeviceName() + ":: Consuming message from Laptop::" + message);

			// Message massageToSend = new Message(HommyUtil.DEVICE_TOKEN);
			// massageToSend.add("message", message);
			// boolean isSend = HTTPUtil.sendMessage(massageToSend);
			// System.out.println("IS SEND? " + isSend);
		}
	}
}

package com.hommy.service;

import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.interfaces.ITopic;

public class RegisterDevice {

	// ITopic tempTopic = TemperatureTopic.getInstance();
	// ITopic timeTopic = TimeTopic.getInstance();
	//
	// // create observers
	// IDeviceSubscriber airConditioner = new AirConditioner("Air
	// Conditioner");
	// IDeviceSubscriber tv = new TV("TV");
	// IDeviceSubscriber alarmClock = new AlarmClock("Alarm Clock");
	//
	// // register observers to the subject
	// tempTopic.register(airConditioner);
	//
	// timeTopic.register(tv);
	// timeTopic.register(alarmClock);
	//
	// // attach observer to subject
	// airConditioner.setTopic(tempTopic);
	// alarmClock.setTopic(timeTopic);
	// tv.setTopic(timeTopic);
	//
	// // now send message to subject
	// tempTopic.publishMessage("Temperature changed to: 24C");
	// timeTopic.publishMessage("Time now is 11:00 AM");

	public static synchronized boolean register(IDeviceSubscriber device, ITopic topic) {
		if (topic != null) {
			device.setTopic(topic);
			return topic.register(device);
		}
		return false;
	}

}

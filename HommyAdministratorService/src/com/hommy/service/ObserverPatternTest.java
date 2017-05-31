package com.hommy.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.hommy.administrator.dao.objects.Device;

public class ObserverPatternTest {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// // create subject
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

		String subnet = getSubnet(InetAddress.getLocalHost().toString());
		checkHosts(subnet);

		System.out.println("Founded ip in this network:");

		Thread.sleep(5000);
		for (Device device : AllDevicesInNetwork.getDevices()) {

			System.out.println(device.getName());

		}

	}

	public static void checkHosts(String subnet) throws UnknownHostException, IOException {
		for (int i = 1; i < 255; i++) {
			String host = subnet + i;
			Thread thread = new Thread(new FindDevicesInTheNetwork(host));
			thread.start();
		}
	}

	public static String getSubnet(String currentIP) {
		int firstSeparator = currentIP.lastIndexOf("/");
		int lastSeparator = currentIP.lastIndexOf(".");
		return currentIP.substring(firstSeparator + 1, lastSeparator + 1);
	}

}

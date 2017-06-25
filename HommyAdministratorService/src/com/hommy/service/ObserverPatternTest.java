package com.hommy.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

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

		String ip;
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				// filters out 127.0.0.1 and inactive interfaces
				if (iface.isLoopback() || !iface.isUp())
					continue;

				System.out.println("NAME: " + iface.getName());

				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while (addresses.hasMoreElements()) {

					InetAddress addr = addresses.nextElement();
					ip = addr.getHostAddress();

					System.out.println(iface.getDisplayName() + " " + ip);
				}
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}

		//
		//
		//
		// String subnet = getSubnet(InetAddress.getLocalHost().toString());
		// checkHosts(subnet);
		//
		// System.out.println("Founded ip in this network:");
		//
		// Thread.sleep(5000);
		// for (Device device : AllDevicesInNetwork.getDevices()) {
		//
		// System.out.println(device.getName());
		//
		// }

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
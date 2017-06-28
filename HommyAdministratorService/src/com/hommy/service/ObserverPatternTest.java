package com.hommy.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.hommy.administrator.dao.objects.Events;
import com.hommy.administrator.dao.objects.RuleDao;
import com.hommy.administrator.dao.objects.Rules;
import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.interfaces.ITopic;

public class ObserverPatternTest {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		HommySystemOperations dd = new HommySystemOperations();

		List<IDeviceSubscriber> devices = dd.getDevices();

		List<ITopic> topics = TopicsPool.getTopics();

		Rules rulesForDevices = dd.getRulesForDevices(21, "Location");

		Events events = dd.getEvents();

		List<RuleDao> allRules = dd.getAllRules();

		Publication pub = new Publication();
		pub.setMessage("TESTWWW");
		pub.setTopicName("LOCATION");
		pub.setNewValue("5");
		pub.setOldValue("9");
		PublicationQueue.addPublication(pub);
		PublicationDispatcher.start();

		PublicationDispatcher.executeImmediately();
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

		// String ip;
		// try {
		// Enumeration<NetworkInterface> interfaces =
		// NetworkInterface.getNetworkInterfaces();
		// while (interfaces.hasMoreElements()) {
		// NetworkInterface iface = interfaces.nextElement();
		// // filters out 127.0.0.1 and inactive interfaces
		// if (iface.isLoopback() || !iface.isUp())
		// continue;
		//
		// System.out.println("NAME: " + iface.getName());
		//
		// Enumeration<InetAddress> addresses = iface.getInetAddresses();
		// while (addresses.hasMoreElements()) {
		//
		// InetAddress addr = addresses.nextElement();
		// ip = addr.getHostAddress();
		//
		// System.out.println(iface.getDisplayName() + " " + ip);
		// }
		// }
		// } catch (SocketException e) {
		// throw new RuntimeException(e);
		// }

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

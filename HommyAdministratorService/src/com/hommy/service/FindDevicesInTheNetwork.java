package com.hommy.service;

import java.io.IOException;
import java.net.InetAddress;

import com.hommy.administrator.dao.objects.Device;

public class FindDevicesInTheNetwork implements Runnable {

	private String host;

	public String getIp() {
		return host;
	}

	public void setIp(String host) {
		this.host = host;
	}

	public FindDevicesInTheNetwork(String host) {
		this.host = host;
	}

	@Override
	public void run() {
		int timeout = 500;

		try {
			InetAddress ip = InetAddress.getByName(host);
			if (ip.isReachable(timeout)) {
				System.out.println(ip.getCanonicalHostName());
				AllDevicesInNetwork.add(new Device(ip.toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

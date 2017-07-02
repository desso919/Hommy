package com.hommy.service.subscribers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hommy.administrator.dao.objects.Rule;
import com.hommy.administrator.dao.objects.Rules;
import com.hommy.service.HommySystemOperations;

public class Laptop extends DeviceSubscriber {

	private static ServerSocket serverSocket;
	private static Socket server;

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

			Rules rules = HommySystemOperations.getRulesForDevices(getId(), message);

			System.out.println("Rules size get from Laptop: " + rules.getRules().size());

			for (Rule rule : rules.getRules()) {
				try {
					String ruleJSON = rule.toJSON();
					sendMessage(ruleJSON);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void initServerSocket() {
		try {
			serverSocket = new ServerSocket(6066);
			serverSocket.setSoTimeout(0);

			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
			server = serverSocket.accept();

			System.out.println("Just connected to " + server.getRemoteSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void sendMessage(String message) {
		DataOutputStream out;
		try {
			out = new DataOutputStream(server.getOutputStream());
			if (message != null) {
				out.writeUTF(message);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

package com.hommy.administrator.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hommy.administrator.dao.objects.Action;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;
import com.hommy.administrator.dao.objects.Event;
import com.hommy.administrator.dao.objects.Rule;
import com.hommy.administrator.dao.objects.User;

public class TestClass {

	public static void main(String[] args) {
		Rule rule = new Rule();
		rule.setName("When I am coming home");
		rule.setUser(new User(1, "Deso", "desp", ""));
		rule.setEvent(new Event(2, "", ""));

		Devices devices = new Devices();
		Device dev = new Device(2, "");
		Action act = new Action(1, "");
		Action act2 = new Action(5, "");
		act.setExecutionOrder(1);
		act2.setExecutionOrder(2);

		List<Action> actions = new ArrayList<Action>();
		actions.add(act);
		actions.add(act2);

		dev.setActions(actions);

		devices.addDevice(dev);

		rule.setDevices(devices);

		boolean result = new RulesOperation().addRule(rule);

		System.out.println();
	}
}
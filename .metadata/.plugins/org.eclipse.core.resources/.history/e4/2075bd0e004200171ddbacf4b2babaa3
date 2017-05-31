package com.hommy.administrator.dao.impl;

import com.hommy.administrator.dao.objects.Action;
import com.hommy.administrator.dao.objects.Device;

public class TestClass {

	public static void main(String[] args) {
		Device dev = new DevicesOperation().getDevice("TV");

		System.out.println(dev);

		for (Action action : dev.getActions()) {
			System.out.println(action.getId());
			System.out.println(action.getAction());
		}

	}
}
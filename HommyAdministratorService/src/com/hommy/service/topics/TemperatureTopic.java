package com.hommy.service.topics;

public class TemperatureTopic extends Topic {

	private static final TemperatureTopic instance = new TemperatureTopic();

	private TemperatureTopic() {
		super("Time topic");
	}

	public static TemperatureTopic getInstance() {
		return instance;
	}
}

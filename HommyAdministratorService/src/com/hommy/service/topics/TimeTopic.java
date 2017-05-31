package com.hommy.service.topics;

public class TimeTopic extends Topic {

	private static final TimeTopic instance = new TimeTopic();

	private TimeTopic() {
		super("Time topic");
	}

	public static TimeTopic getInstance() {
		return instance;
	}
}

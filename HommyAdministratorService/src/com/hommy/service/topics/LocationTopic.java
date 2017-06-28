package com.hommy.service.topics;

public class LocationTopic extends Topic {

	private static final LocationTopic instance = new LocationTopic();

	public static LocationTopic getInstance() {
		return instance;
	}

	public LocationTopic() {
		super("Location");
	}

}

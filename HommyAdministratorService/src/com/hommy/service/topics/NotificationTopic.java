package com.hommy.service.topics;

public class NotificationTopic extends Topic {

	private static final NotificationTopic instance = new NotificationTopic();

	public static NotificationTopic getInstance() {
		return instance;
	}

	public NotificationTopic() {
		super("Notification Topic");
	}

}

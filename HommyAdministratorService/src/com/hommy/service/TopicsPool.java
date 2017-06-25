package com.hommy.service;

import java.util.ArrayList;
import java.util.List;

import com.hommy.service.interfaces.ITopic;
import com.hommy.service.topics.NotificationTopic;
import com.hommy.service.topics.TemperatureTopic;
import com.hommy.service.topics.TimeTopic;

public final class TopicsPool {

	private static List<ITopic> topics = new ArrayList<ITopic>();

	static {
		topics.add(TimeTopic.getInstance());
		topics.add(TemperatureTopic.getInstance());
		topics.add(NotificationTopic.getInstance());
	}

	public List<ITopic> getTopics() {
		return topics;
	}

	public boolean addTopic(ITopic topic) {
		if (topic != null) {
			return topics.add(topic);
		}
		return false;
	}

	public static synchronized ITopic getTopic(String topicName) {

		ITopic topic = null;

		if (topicName.equalsIgnoreCase("Time")) {
			topic = TimeTopic.getInstance();
		} else if (topicName.equalsIgnoreCase("Temperature")) {
			topic = TemperatureTopic.getInstance();
		} else if (topicName.equalsIgnoreCase("Notification")) {
			topic = TemperatureTopic.getInstance();
		}

		return topic;
	}
}
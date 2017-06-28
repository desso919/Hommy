package com.hommy.service;

import java.util.ArrayList;
import java.util.List;

import com.hommy.service.interfaces.ITopic;
import com.hommy.service.topics.LocationTopic;
import com.hommy.service.topics.NotificationTopic;
import com.hommy.service.topics.TemperatureTopic;
import com.hommy.service.topics.TimeTopic;

public final class TopicsPool {

	private static List<ITopic> topics = new ArrayList<ITopic>();

	static {
		topics.add(TimeTopic.getInstance());
		topics.add(TemperatureTopic.getInstance());
		topics.add(NotificationTopic.getInstance());
		topics.add(LocationTopic.getInstance());
	}

	public static List<ITopic> getTopics() {
		return topics;
	}

	public boolean addTopic(ITopic topic) {
		if (topic != null) {
			return topics.add(topic);
		}
		return false;
	}

	public static synchronized ITopic getTopic(Topics topicName) {

		ITopic topic = null;

		if (topicName == Topics.TIME) {
			topic = TimeTopic.getInstance();
		} else if (topicName == Topics.TEMPERATURE) {
			topic = TemperatureTopic.getInstance();
		} else if (topicName == Topics.NOTIFICATION) {
			topic = NotificationTopic.getInstance();
		} else if (topicName == Topics.LOCATION) {
			topic = LocationTopic.getInstance();
		}

		return topic;
	}

	public static synchronized ITopic getTopicString(String topicName) {

		ITopic topic = null;

		if (topicName.equalsIgnoreCase(Topics.TIME.toString())) {
			topic = TimeTopic.getInstance();
		} else if (topicName.equalsIgnoreCase(Topics.TEMPERATURE.toString())) {
			topic = TemperatureTopic.getInstance();
		} else if (topicName.equalsIgnoreCase(Topics.NOTIFICATION.toString())) {
			topic = NotificationTopic.getInstance();
		} else if (topicName.equalsIgnoreCase(Topics.LOCATION.toString())) {
			topic = LocationTopic.getInstance();
		}

		return topic;
	}
}

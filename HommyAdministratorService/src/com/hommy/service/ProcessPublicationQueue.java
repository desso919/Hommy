package com.hommy.service;

import java.util.TimerTask;

import com.hommy.service.interfaces.ITopic;

public class ProcessPublicationQueue extends TimerTask {

	@Override
	public void run() {
		Publication publication = PublicationQueue.pollPublication();

		if (publication != null) {
			System.out.println("Procesing publication: " + publication.getMessage());

			ITopic topic = TopicsPool.getTopic(publication.getTopicName());
			topic.publishMessage(publication.getMessage());
		} else {
			System.out.println("Publication queue is empty, hence do nothing.");
		}
	}

}

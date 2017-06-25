package com.hommy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Publication {

	private int authToken;
	private String topicName;
	private String oldValue;
	private String newValue;
	private String message;

	public Publication() {
	}

	public Publication(int id, String topicName, String oldValue, String newValue, String message) {
		this.authToken = id;
		this.topicName = topicName;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.message = message;
	}

	public int getId() {
		return authToken;
	}

	public void setId(int id) {
		this.authToken = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topic) {
		this.topicName = topic;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Publication [id=" + authToken + ", topic=" + topicName + ", oldValue=" + oldValue + ", newValue="
				+ newValue + ", message=" + message + "]";
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
}

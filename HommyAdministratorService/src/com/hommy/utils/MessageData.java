package com.hommy.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageData {

	private Map<String, String> data = new HashMap<String, String>();

	public MessageData() {
	}

	public boolean add(String key, String value) {
		if (data.containsKey(key)) {
			return false;
		} else {
			data.put(key, value);
			return true;
		}
	}

	public boolean remove(String key, String value) {
		if (data.containsKey(key)) {
			data.remove(key, value);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(String key) {
		if (data.containsKey(key)) {
			data.remove(key);
			return true;
		} else {
			return false;
		}
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}

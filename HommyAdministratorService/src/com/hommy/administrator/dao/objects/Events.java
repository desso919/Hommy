package com.hommy.administrator.dao.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Events {
	private List<Event> events;

	public Events() {
		events = new ArrayList<Event>();
	}

	public Events(List<Event> events) {
		this.events = events;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public boolean addEvent(Event Event) {
		if (Event != null) {
			events.add(Event);
			return true;
		}
		return false;
	}

	public Event getEvent(int index) {
		return events.get(index);
	}

	public Event getEvent(String name) {
		for (Event event : events) {
			if (event.getName().equals(name)) {
				return event;
			}
		}

		return null;
	}

	public boolean containsEventWithName(String name) {
		for (Event event : events) {
			if (event.getName().equals(name)) {
				return true;
			}
		}

		return false;
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
}
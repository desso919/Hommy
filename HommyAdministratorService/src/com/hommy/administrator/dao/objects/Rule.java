package com.hommy.administrator.dao.objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Rule {

	private int id;
	private String name;
	private User user;
	private Event event;
	private Devices devices;
	private Action action;

	public Rule() {
	}

	public Rule(String name) {
		this.name = name;
	}

	public Rule(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Rule(int id, String name, User user, Event event, Devices device, Action action) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.event = event;
		this.devices = device;
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Devices getDevices() {
		return devices;
	}

	public void setDevices(Devices devices) {
		this.devices = devices;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Rule [name=" + name + ", id=" + id + ", device=" + devices + ", action=" + action + "]";
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}

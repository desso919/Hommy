package com.hommy.administrator.dao.interfaces;

import com.hommy.administrator.dao.objects.Event;
import com.hommy.administrator.dao.objects.Events;

public interface IEvent {

	public Events getAllEvents();

	public Event getEvent(String name);

	public boolean addEvent(Event event);

	public boolean removeEvent(int id);
}

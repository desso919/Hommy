package com.hommy.service.topics;

import java.util.ArrayList;
import java.util.List;

import com.hommy.service.interfaces.IDeviceSubscriber;
import com.hommy.service.interfaces.ITopic;

public abstract class Topic implements ITopic {

	private List<IDeviceSubscriber> subscribers = new ArrayList<IDeviceSubscriber>();
	private final Object MUTEX = new Object();
	private final String topicName;
	private String message;
	private boolean isChanged;

	public Topic(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicName() {
		return topicName;
	}

	public List<IDeviceSubscriber> getSubscribers() {
		return subscribers;
	}

	public String getMessage() {
		return message;
	}

	public boolean isChanged() {
		return isChanged;
	}

	@Override
	public boolean register(IDeviceSubscriber device) {
		if (device != null) {
			synchronized (MUTEX) {
				if (!subscribers.contains(device))
					return subscribers.add(device);
			}
		}
		return false;
	}

	@Override
	public boolean unregister(IDeviceSubscriber device) {
		if (device != null) {
			synchronized (MUTEX) {
				return subscribers.remove(device);
			}
		}

		return false;
	}

	@Override
	public void notifySubscribers() {
		List<IDeviceSubscriber> observersLocal = null;
		// synchronization is used to make sure any observer registered after
		// message is received is not notified
		synchronized (MUTEX) {
			if (!isChanged)
				return;
			observersLocal = new ArrayList<>(this.subscribers);
			this.isChanged = false;
		}
		for (IDeviceSubscriber device : observersLocal) {
			device.update();
		}
	}

	@Override
	public Object getUpdate(IDeviceSubscriber device) {
		return this.message;
	}

	@Override
	public void publishMessage(Object message) {
		System.out.println("Message Published to Topic:" + message);
		this.message = (String) message;
		this.isChanged = true;
		notifySubscribers();
	}

}

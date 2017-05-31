package com.hommy.service.interfaces;

public interface ITopic {

	/**
	 * This methods is for register new device.
	 * 
	 * @param device
	 */
	public boolean register(IDeviceSubscriber device);

	/**
	 * This methods is for unregister device.
	 * 
	 * @param device
	 */
	public boolean unregister(IDeviceSubscriber device);

	/**
	 * This method is used to notify the subscribers of change
	 */
	public void notifySubscribers();

	/**
	 * This method is used to get updates from topic
	 * 
	 * @param device
	 * @return
	 */
	public Object getUpdate(IDeviceSubscriber device);

	/**
	 * This method is used to publish message to the topic
	 * 
	 * @param message
	 */
	public void publishMessage(Object message);
}

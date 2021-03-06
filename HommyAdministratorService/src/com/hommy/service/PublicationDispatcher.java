package com.hommy.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PublicationDispatcher {

	private static final int DEFAULT_PERIOD_OF_RUNNING = 3;
	private static final int NUMBER_OF_THREAD_TO_KEEP_IN_THE_POOL = 10;

	static {
		start();
	}

	private static ScheduledExecutorService executor;
	private static boolean isStarted;

	public static void start() {
		if (!isStarted) {
			System.out.println("Starting publication dispatcher.");

			executor = Executors.newScheduledThreadPool(NUMBER_OF_THREAD_TO_KEEP_IN_THE_POOL);
			executor.scheduleAtFixedRate(new ProcessPublicationQueue(), 0, DEFAULT_PERIOD_OF_RUNNING, TimeUnit.SECONDS);
			isStarted = true;

		} else {
			System.out.println("Publication dispatcher is already started.");
		}
	}

	public static void start(int periodOfRunningTask) {
		if (!isStarted) {
			System.out.println("Starting publication dispatcher.");

			executor = Executors.newScheduledThreadPool(NUMBER_OF_THREAD_TO_KEEP_IN_THE_POOL);
			executor.scheduleAtFixedRate(new ProcessPublicationQueue(), 0, periodOfRunningTask, TimeUnit.SECONDS);
			isStarted = true;

		} else {
			System.out.println("Publication dispatcher is already started.");
		}
	}

	public static void stop() {
		if (isStarted) {
			executor.shutdown();
			isStarted = false;
		} else {
			System.out.println("Publication dispatcher is already stoped.");
		}
	}

	public static boolean isStarted() {
		return isStarted;
	}

	public static boolean isBusy() {
		if (PublicationQueue.size() <= 5) {
			return false;
		}
		return true;
	}

	public static void executeImmediately() {
		new Thread(new ProcessPublicationQueue()).start();
	}

}

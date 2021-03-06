package com.hommy.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PublicationQueue {
	private static BlockingQueue<Publication> queue = new LinkedBlockingQueue<Publication>();

	public static boolean addPublication(Publication publication) {
		if (publication != null) {
			return queue.offer(publication);
		}
		return false;
	}

	public static boolean removePublication(Publication publication) {
		if (publication != null) {
			return queue.remove(publication);
		}
		return false;
	}

	public static Publication pollPublication() {
		return queue.poll();
	}

	public static Publication peekPublication() {
		return queue.peek();
	}

	public static int size() {
		return queue.size();
	}

}

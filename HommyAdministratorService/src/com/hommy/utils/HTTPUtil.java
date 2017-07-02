package com.hommy.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HTTPUtil {

	public static Boolean KEEP_THE_CONNECTION = true;

	public static boolean sendMessage(Message message) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(HommyUtil.GOOGLE_CLOUD_MESSAGING_URI);

		post.addHeader("Authorization", HommyUtil.AUTHORIZATION_GOOGLE_SERVER_KEY);
		post.addHeader("Content-Type", HommyUtil.CONTENT_TYPE_JSON);
		StringEntity postingString;
		StringBuffer result = new StringBuffer();

		try {
			postingString = new StringEntity(message.toJSON());
			System.out.println(message.toJSON());
			post.setEntity(postingString);

			HttpResponse httpResponse = client.execute(post);

			if (httpResponse.getStatusLine().getStatusCode() == HommyUtil.HTTP_STATUS_CODE_OK) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				ObjectMapper mapper = new ObjectMapper();
				MessageResponse response = mapper.readValue(result.toString(), MessageResponse.class);

				return isSuccessfullyReceived(response);

			} else {
				System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean sendMessageToLaptop(Message message) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(HommyUtil.GOOGLE_CLOUD_MESSAGING_URI);

		post.addHeader("Authorization", HommyUtil.AUTHORIZATION_GOOGLE_SERVER_KEY);
		post.addHeader("Content-Type", HommyUtil.CONTENT_TYPE_JSON);
		StringEntity postingString;
		StringBuffer result = new StringBuffer();

		try {
			postingString = new StringEntity(message.toJSON());
			System.out.println(message.toJSON());
			post.setEntity(postingString);

			HttpResponse httpResponse = client.execute(post);

			if (httpResponse.getStatusLine().getStatusCode() == HommyUtil.HTTP_STATUS_CODE_OK) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				ObjectMapper mapper = new ObjectMapper();
				MessageResponse response = mapper.readValue(result.toString(), MessageResponse.class);

				return isSuccessfullyReceived(response);

			} else {
				System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	private static boolean isSuccessfullyReceived(MessageResponse response) {
		int numberOfNotifiedDevices = response.getSuccess();
		int numberOfNOTNotifiedDevices = response.getFailure();

		if (numberOfNotifiedDevices > 0 && numberOfNOTNotifiedDevices == 0) {
			return true;
		}

		return false;
	}
}

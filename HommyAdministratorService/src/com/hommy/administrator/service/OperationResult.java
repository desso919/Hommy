package com.hommy.administrator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OperationResult {

	private Result result;
	private String resultMessage;
	private String recommendedMessage;

	public OperationResult(Result result) {
		this.result = result;
	}

	public OperationResult(Result result, String resultMessage) {
		this(result);
		this.resultMessage = resultMessage;
	}

	public OperationResult(Result result, String resultMessage, String recommendedMessage) {
		this(result, resultMessage);
		this.recommendedMessage = recommendedMessage;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getRecommendedMessage() {
		return recommendedMessage;
	}

	public void setRecommendedMessage(String recommendedMessage) {
		this.recommendedMessage = recommendedMessage;
	}

	@Override
	public String toString() {
		return "OperationResult [result=" + result + ", resultMessage=" + resultMessage + ", recommendedMessage="
				+ recommendedMessage + "]";
	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
}

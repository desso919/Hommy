package com.hommy.administrator.dao.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Rules {

	private List<Rule> rules;

	public Rules() {
		rules = new ArrayList<Rule>();
	}

	public Rules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public boolean addRule(Rule rule) {
		if (rule != null) {
			rules.add(rule);
			return true;
		}
		return false;
	}

	public Rule getRule(int index) {
		return rules.get(index);
	}

	public Rule getRule(String name) {
		for (Rule rule : rules) {
			if (rule.getName().equals(name)) {
				return rule;
			}
		}

		return null;
	}

	public boolean containsRuleWithName(String name) {
		for (Rule rule : rules) {
			if (rule.getName().equals(name)) {
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

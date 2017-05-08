package com.hommy.administrator.dao.interfaces;

import java.util.List;

import com.hommy.administrator.dao.objects.Rule;

public interface IRule {

	public List<Rule> getAllRules();

	public Rule getRule();

	public void addRule();

	public void removeRule();
}

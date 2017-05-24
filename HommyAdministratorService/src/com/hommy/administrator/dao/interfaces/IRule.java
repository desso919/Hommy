package com.hommy.administrator.dao.interfaces;

import com.hommy.administrator.dao.objects.Rule;
import com.hommy.administrator.dao.objects.Rules;

public interface IRule {

	public Rules getAllRules();

	public Rule getRule();

	public void addRule();

	public void removeRule();
}

package com.hommy.administrator.dao.interfaces;

import java.util.List;

import com.hommy.administrator.dao.objects.Action;

public interface IAction {

	public List<Action> getActions(List<Integer> Actionsid);

	public boolean addAction(Action action);
}

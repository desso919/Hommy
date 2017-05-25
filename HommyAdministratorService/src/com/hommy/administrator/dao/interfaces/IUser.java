package com.hommy.administrator.dao.interfaces;

import com.hommy.administrator.dao.objects.User;

public interface IUser {

	public User getUser(String username, String password);

	public void addUser(User user);

	public void removeUser(User user);
}

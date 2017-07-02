package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hommy.administrator.dao.interfaces.IUser;
import com.hommy.administrator.dao.objects.User;
import com.hommy.database.DatabaseManager;

public class UsersOperation implements IUser {

	@Override
	public User getUser(String username, String password) {
		Connection connection = DatabaseManager.createConnection();

		String query = "select * from users where username=? and password=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("email");

				return new User(id, username, password, email);
			} else {
				System.out.println("User does not exist");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

}

package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hommy.administrator.dao.interfaces.IAction;
import com.hommy.administrator.dao.objects.Action;
import com.hommy.database.DatabaseManager;

public class ActionsOperation implements IAction {

	@Override
	public List<Action> getActions(List<Integer> Actionsid) {

		if (Actionsid.size() == 0) {
			return new ArrayList<Action>();
		}

		Connection connection = DatabaseManager.createConnection();
		List<Action> actions = new ArrayList<Action>();

		StringBuilder query = new StringBuilder("select * from actions where id IN (");

		PreparedStatement preparedStatement;
		try {

			for (int i = 0; i < Actionsid.size(); i++) {
				query.append("?,");
			}

			int lastindex = query.lastIndexOf(",");
			query.replace(lastindex, lastindex + 1, ")");

			preparedStatement = connection.prepareStatement(query.toString());

			int index = 1;
			for (Integer id : Actionsid) {
				preparedStatement.setInt(index++, id);
			}

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String action = resultSet.getString("action");
				actions.add(new Action(id, action));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actions;
	}

	@Override
	public boolean addAction(Action action) {
		Connection connection = DatabaseManager.createConnection();
		int result = 0;

		String insertSQL = "INSERT INTO actions (action) VALUES (?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, action.getAction());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result == 1) {
			return true;
		}
		return false;

	}

}

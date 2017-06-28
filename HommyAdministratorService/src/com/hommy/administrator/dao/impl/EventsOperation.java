package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hommy.administrator.dao.interfaces.IEvent;
import com.hommy.administrator.dao.objects.Event;
import com.hommy.administrator.dao.objects.Events;
import com.hommy.database.DatabaseManager;

public class EventsOperation implements IEvent {

	static {
		DatabaseManager.initialize();
	}

	@Override
	public Events getAllEvents() {
		Connection connection = DatabaseManager.createConnection();
		Events events = new Events();

		String query = "select * from events";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String eventName = resultSet.getString("eventname");
				String description = resultSet.getString("description");
				String triggeredBy = resultSet.getString("triggeredBy");

				System.out.println("Event: " + id + "  " + eventName + "   " + description);
				Event event = new Event(id, eventName, description);
				event.setTriggeredBy(triggeredBy);
				events.addEvent(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return events;
	}

	public Event getEvent(Connection connection, int id) {
		String query = "select * from events where id=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String eventName = resultSet.getString("eventname");
				String description = resultSet.getString("description");

				System.out.println("Event: " + id + "  " + eventName + "   " + description);

				return new Event(id, eventName, description);
			} else {
				System.out.println("Event with this Id: " + id + " does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Event getEvent(String name) {
		Connection connection = DatabaseManager.createConnection();

		String query = "select * from events where eventname=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String eventName = resultSet.getString("eventname");
				String description = resultSet.getString("description");

				System.out.println("Event: " + id + "  " + eventName + "   " + description);

				return new Event(id, eventName, description);
			} else {
				System.out.println("Event with name: " + name + " does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addEvent(Event event) {
		Connection connection = DatabaseManager.createConnection();
		int result = 0;

		String insertSQL = "INSERT INTO Events (eventname, description, triggeredBy) VALUES (?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, event.getName());
			preparedStatement.setString(2, event.getDescription());
			preparedStatement.setString(3, event.getTriggeredBy());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEvent(int id) {
		Connection connection = DatabaseManager.createConnection();
		int result = 0;

		String query = "delete from events where id=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 0) {
			return false;
		}
		return true;
	}

}

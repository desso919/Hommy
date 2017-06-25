package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hommy.administrator.dao.interfaces.IDevice;
import com.hommy.administrator.dao.objects.Action;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;
import com.hommy.database.DatabaseManager;

public class DevicesOperation implements IDevice {

	static {
		DatabaseManager.initialize();
	}

	@Override
	public Devices getAllDevice() {
		Connection connection = DatabaseManager.createConnection();
		Devices devices = new Devices();

		String query = "select * from devices";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String deviceName = resultSet.getString("deviceName");
				String communicationProtocol = resultSet.getString("communicationprotocol");

				System.out.println("Device: " + id + "  " + deviceName + "   " + communicationProtocol);
				Device device = getDevice(deviceName);

				devices.addDevice(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return devices;
	}

	@Override
	public Device getDevice(String name) {
		Connection connection = DatabaseManager.createConnection();

		String query = "select * from devices where devicename=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String deviceName = resultSet.getString("deviceName");
				String communicationProtocol = resultSet.getString("communicationprotocol");
				List<Integer> actionsId = getDeviceActions(connection, id);

				List<Action> actions = new ActionsOperation().getActions(actionsId);

				System.out.println("Event: " + id + "  " + deviceName + "   " + communicationProtocol);

				return new Device(id, deviceName, actions);
			} else {
				System.out.println("Device with name: " + name + " does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addDevice(Device device) {
		Connection connection = DatabaseManager.createConnection();
		int result = 0;

		String insertSQL = "INSERT INTO devices (devicename, communicationprotocol) VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, device.getName());
			preparedStatement.setString(2, device.getProtocol().toString());
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
	public boolean removeDevice(int id) {
		Connection connection = DatabaseManager.createConnection();
		int result = 0;

		String query = "delete from devices where id=?";

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

	private List<Integer> getDeviceActions(Connection connection, int deviceId) throws SQLException {
		String query = "select actionId from DEVICEACTIONS where deviceID=?";
		List<Integer> actionsID = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, deviceId);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("actionId");
			actionsID.add(id);
		}

		return actionsID;
	}

}

package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hommy.administrator.dao.interfaces.IRule;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Rule;
import com.hommy.database.DatabaseConnection;

public class Rules implements IRule {

	private List<Rule> rules = new ArrayList<Rule>();

	static {
		DatabaseConnection.initialize();
	}

	@Override
	public List<Rule> getAllRules() {
		Connection connection = DatabaseConnection.createConnection();
		String query = "select * from rules";

		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("All rules: ");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int device = resultSet.getInt("device");
				String action = resultSet.getString("action");

				System.out.println("Rule: " + id + "  " + name + "   " + device + "  " + action);

				Rule rule = new Rule(name, String.valueOf(id),
						new Device("Washing machine", String.valueOf(device), "225.255.255.0"), action);
				rules.add(rule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rules;
	}

	@Override
	public Rule getRule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRule() {
		// TODO Auto-generated method stub

	}

	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
}

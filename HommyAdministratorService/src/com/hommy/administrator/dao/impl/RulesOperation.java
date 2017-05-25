package com.hommy.administrator.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hommy.administrator.dao.interfaces.IRule;
import com.hommy.administrator.dao.objects.Rule;
import com.hommy.administrator.dao.objects.Rules;
import com.hommy.database.DatabaseConnection;

public class RulesOperation implements IRule {

	static {
		DatabaseConnection.initialize();
	}

	@Override
	public Rules getAllRules() {
		Connection connection = DatabaseConnection.createConnection();
		List<Rule> rules = new ArrayList<Rule>();
		Rules rulesManage = new Rules();
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rulesManage.setRules(rules);
		return rulesManage;
	}

	@Override
	public Rule getRule(Rule rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRule(Rule rule) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRule(Rule rule) {
		// TODO Auto-generated method stub

	}

}

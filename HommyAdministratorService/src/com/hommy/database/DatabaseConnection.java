package com.hommy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Static class that provides methods for working with the database.
 * 
 * @author Desislav
 */
public class DatabaseConnection {

	/**
	 * Initialize oracle jdbc driver
	 * 
	 */
	public static void initialize() {

		System.out.println("-------- Initialize Oracle JDBC ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("Oracle JDBC Driver Registered!");
	}

	/**
	 * Create connection th the databse and return it.
	 * 
	 * @return connection to database
	 */
	public static Connection createConnection() {
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:HommyDB", "deso", "deso");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		// TODO config logger and log messages.
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

}
package com.hommy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Static class that provides methods for working with the database.
 * 
 * @author Desislav
 */
public class DatabaseManager {

	static String url = "jdbc:oracle:thin:@localhost:1521:HommyDB";
	static String user = "deso";
	static String password = "deso";

	/**
	 * Initialize oracle jdbc driver
	 * 
	 */
	public static void initialize() {

		System.out.println("-------- Initialize Oracle JDBC ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * Create connection to the database.
	 * 
	 * @return connection to database
	 */
	public static Connection createConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		return connection;
	}

}

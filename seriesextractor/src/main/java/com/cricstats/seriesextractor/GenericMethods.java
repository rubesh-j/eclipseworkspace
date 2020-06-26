package com.cricstats.seriesextractor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods {

	public WebDriver intiateDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		return new ChromeDriver();
	}
	
	public static Connection startConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(App.prop.getProperty("hostname"),App.prop.getProperty("username"), App.prop.getProperty("pswd"));
		System.out.println(connection.isValid(60000));
		return connection;
	}
}

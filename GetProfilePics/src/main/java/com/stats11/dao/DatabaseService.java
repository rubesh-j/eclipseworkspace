package com.stats11.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import com.stats11.main.UpdateURL;

public class DatabaseService extends UpdateURL {
	private static String url = "jdbc:mysql://18.139.85.190:3306/statisticks";
	private static String user = "uipath1";
	private static String password = "AWS2019!!";
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");  
		Connection connect = DriverManager.getConnection(url, user, password);
		return connect;
	}
	
	public static ResultSet getPlayerURL(Connection conn) throws SQLException {
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT DISTINCT replace(replace(PLAYER_NAME,'+',''),'(c)','') player_name, player_url FROM PLAYER_SCRAP");  
		return rs;
	}
	
	public static void updateUrl(Connection conn, String url, String name) throws SQLException {
		String query = "update PLAYER_SCRAP set IMG_URL='" + url + "' where PLAYER_NAME = '" + name + "'";
		try {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Database updated successfully ");
		}
		catch(SQLSyntaxErrorException e) {
			errorPlayers.add(name);
		}
	}
}

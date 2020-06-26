package com.cricstats.seriesextractor.dbUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.cricstats.seriesextractor.App;
import com.cricstats.seriesextractor.GenericMethods;

public class DatabaseFunctions extends App {

	public static void insertSeriesInfo(List<HashMap<String, String>> seriesInfoList)
			throws ClassNotFoundException, SQLException {
		String sql = "Insert into uiextract.T20_SERIES_INFO_FINAL values (? , ? );";
		try (Connection connection = GenericMethods.startConnection();) {
			connection.setAutoCommit(false);
			CallableStatement prepStmt = connection.prepareCall("{call uiextract.usp_INS_SERIES_INFO(?, ?)}");
			seriesInfoList.forEach(eachmap -> {
				try {
					prepStmt.setString(1, eachmap.get("Team"));
					prepStmt.setString(2, eachmap.get("Result"));
					prepStmt.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			try {
				int[] updateCounts = prepStmt.executeBatch();
				System.out.println(updateCounts.length);
				logger.info("Batch Update Return Code : " + Arrays.toString(updateCounts));
				
				}
				catch(Exception e) {
					logger.error("Insertion failed for SeriesInfo");
				}
				
			connection.commit();
			connection.setAutoCommit(true);
		}
	}

	public static void insertMatchInfo(List<HashMap<String, String>> matchInfoList)
			throws ClassNotFoundException, SQLException {

		try (Connection connection = GenericMethods.startConnection();) {
			connection.setAutoCommit(false);
			CallableStatement prepStmt = connection
					.prepareCall("{call uiextract.usp_INS_MATCH_RESULTS(?, ?,?,?,?,?)}");
			matchInfoList.forEach(eachmap -> {
				try {
					prepStmt.setString(1, eachmap.get("SeriesName"));
					prepStmt.setString(2, eachmap.get("Match"));
					prepStmt.setString(3, eachmap.get("Innings 1"));
					prepStmt.setString(4, eachmap.get("Innings 2"));
					prepStmt.setString(5, eachmap.get("Match Status"));
					prepStmt.setString(6, eachmap.get("ScorecardURL"));
					prepStmt.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			try {
			int[] updateCounts = prepStmt.executeBatch();
			System.out.println(updateCounts.length);
			logger.info("Batch Update Return Code : " + Arrays.toString(updateCounts));
			
			}
			catch(Exception e) {
				logger.error("Insertion failed for MatchINFO");
			}
			
			
			connection.commit();
			connection.setAutoCommit(true);
		}
	}

	public static void insertBowlerInfo(List<HashMap<String, String>> batsmanInfoList)
			throws ClassNotFoundException, SQLException {

		try (Connection connection = GenericMethods.startConnection();) {
			connection.setAutoCommit(false);
			CallableStatement prepStmt = connection
					.prepareCall("{call uiextract.usp_INS_SCORECARD_BOWL(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			batsmanInfoList.forEach(eachmap -> {
				try {
					prepStmt.setString(1, eachmap.get("Bowler"));
					prepStmt.setString(2, eachmap.get("Over"));
					prepStmt.setString(3, eachmap.get("Maiden"));
					prepStmt.setString(4, eachmap.get("Run"));
					prepStmt.setString(5, eachmap.get("Wkt"));
					prepStmt.setString(6, eachmap.get("Econ"));
					prepStmt.setString(7, eachmap.get("Dot"));
					prepStmt.setString(8, eachmap.get("Four"));
					prepStmt.setString(9, eachmap.get("Six"));
					prepStmt.setString(10, eachmap.get("Wide"));
					prepStmt.setString(11, eachmap.get("NB"));
					prepStmt.setString(12, eachmap.get("Match_ID"));
					prepStmt.setString(13, eachmap.get("Series_ID"));
					prepStmt.setString(14, eachmap.get("Team"));
					prepStmt.setInt(15, Integer.parseInt(eachmap.get("Innings")));
					prepStmt.setString(16, eachmap.get("BowlerURL"));
					prepStmt.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			try {
				int[] updateCounts = prepStmt.executeBatch();
				System.out.println(updateCounts.length);
				logger.info("Batch Update Return Code : " + Arrays.toString(updateCounts));
				
				}
				catch(Exception e) {
					logger.error("Insertion failed for Bowler Info");
				}
				
			connection.commit();
			connection.setAutoCommit(true);
		}
	}

	public static void insertBatsmanInfo(List<HashMap<String, String>> batsmanInfoList)
			throws ClassNotFoundException, SQLException {

		try (Connection connection = GenericMethods.startConnection();) {
			connection.setAutoCommit(false);
			CallableStatement prepStmt = connection
					.prepareCall("{call uiextract.usp_INS_SCORECARD_BAT(?, ?,?,?,?,?,?,?,?,?,?,?)}");
			batsmanInfoList.forEach(eachmap -> {
				try {
					prepStmt.setString(1, eachmap.get("Name"));
					prepStmt.setString(2, eachmap.get("Out"));
					prepStmt.setString(3, eachmap.get("Runs"));
					prepStmt.setString(4, eachmap.get("Balls"));
					prepStmt.setString(5, eachmap.get("Four"));
					prepStmt.setString(6, eachmap.get("Six"));
					prepStmt.setString(7, eachmap.get("StrikeRate"));
					prepStmt.setString(8, eachmap.get("Match_ID"));
					prepStmt.setString(9, eachmap.get("Series_ID"));
					prepStmt.setString(10, eachmap.get("Team"));
					prepStmt.setInt(11, Integer.parseInt(eachmap.get("Innings")));
					prepStmt.setString(12, eachmap.get("BatsmanURL"));
					prepStmt.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			try {
				int[] updateCounts = prepStmt.executeBatch();
				System.out.println(updateCounts.length);
				logger.info("Batch Update Return Code : " + Arrays.toString(updateCounts));
				
				}
				catch(Exception e) {
					logger.error("Insertion failed for Batsman Info");
				}
				
			connection.commit();
			connection.setAutoCommit(true);
		}
	}
	public static List<HashMap<String,String>> getScorecardDetails() throws SQLException, ClassNotFoundException {
		List<HashMap<String,String>> scoreUtilsList = new ArrayList<HashMap<String,String>>();
		try (Connection connection = GenericMethods.startConnection();) {
			PreparedStatement prepStmt = connection.prepareStatement("SELECT * FROM uiextract.T20_MATCH_RESULTS_FINAL  WHERE upper(result) not in ('Match abandoned without a ball bowled','No result') ;");
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next())
			{
				HashMap<String,String> scoreCardMap = new HashMap<String,String>();
				scoreCardMap.put("URL",rs.getString("score_url"));
				scoreCardMap.put("MatchID",rs.getString("match_id"));
				scoreCardMap.put("SeriesID",rs.getString("series_id"));
				scoreCardMap.put("Result", rs.getString("result"));
				scoreUtilsList.add(scoreCardMap);
				scoreCardMap =null;
			}
			}
		return scoreUtilsList;
	}
	
	public static HashMap<String,String> getPlayerImgEmpytyDetails() throws ClassNotFoundException, SQLException{
		HashMap<String,String> playerDetails = new HashMap<String,String>();
		try (Connection connection = GenericMethods.startConnection();) {
			PreparedStatement prepStmt = connection.prepareStatement("SELECT player_id, player_url FROM cricstats.PLAYER_MASTER  WHERE player_img_url is null;");
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next())
			{
				playerDetails.put(rs.getString("player_id"), rs.getString("player_url"));

			}
			}
		
		
		return playerDetails;
			
		
	}
	
	public static void insertPlayerImg(HashMap<String, String> playerImg)
			throws ClassNotFoundException, SQLException {
		String sql = "Insert into uiextract.T20_SERIES_INFO_FINAL values (? , ? );";
		try (Connection connection = GenericMethods.startConnection();) {
			connection.setAutoCommit(false);
			PreparedStatement prepStmt = connection.prepareStatement("update cricstats.PLAYER_MASTER set player_img_url=? where player_id=?");
			playerImg.forEach((playerId, playerImgURL) -> {
				try {
					prepStmt.setString(1, playerImgURL);
					prepStmt.setString(2, playerId);
					prepStmt.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			try {
				int[] updateCounts = prepStmt.executeBatch();
				System.out.println(updateCounts.length);
				logger.info("Batch Update Return Code : " + Arrays.toString(updateCounts));
				
				}
				catch(Exception e) {
					logger.error("Insertion failed for SeriesInfo");
				}
				
			connection.commit();
			connection.setAutoCommit(true);
		}
	}
	

}

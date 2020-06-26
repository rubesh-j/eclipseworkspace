package com.cricstats.seriesextractor.uiPages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

public class T20ScoreCardPage extends ExtractData {

	public static int j;
	public static String BASE_XPATH = "//article[@class='sub-module scorecard']";
	public static String TEAM_XPATH = "//div[@class='accordion-header']";
	public static String BATSMAN_XPATH = "//div[@class='flex-row']";
	public static String BOWLER_XPATH = "//div[@class='scorecard-section bowling']/table/tbody/tr";
	// article[@class='sub-module scorecard'][1]

	public static List<HashMap<String, String>> getBatsmenList(String series_id, String match_id) {
		List<HashMap<String, String>> batsmenList = new ArrayList<HashMap<String, String>>();
		int Innings_Size = driver.findElements(By.xpath(BASE_XPATH)).size();
		for (int i = 1; i <= Innings_Size; i++) {
			String team = driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + TEAM_XPATH)).getText();
			logger.info("Batting Data is being fetched for " + team);
			int batsman_size = driver
					.findElements(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "/div[@class='wrap batsmen']"))
					.size();
			for (int j = 1; j <= batsman_size; j++) {
				HashMap<String, String> batsmanMap = new HashMap<String, String>();
				int header_size = driver
						.findElements(By.xpath(
								BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "[1]/div[@class='wrap batsmen']/div"))
						.size();
				// System.out.println(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "/div[1]/a");
				batsmanMap.put("Team", team);
				batsmanMap.put("Innings", String.valueOf(i));
				batsmanMap.put("Series_ID", series_id);
				batsmanMap.put("Match_ID", match_id);
				try {
					batsmanMap.put("Name", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "["
							+ j + "]/div[@class='wrap batsmen']/div[1]/a")).getText());
				} catch (Exception e) {
					batsmanMap.put("Name", "");
				}
				try {
					batsmanMap.put("Out", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "["
							+ j + "]/div[@class='wrap batsmen']/div[2]")).getText());
				} catch (Exception e) {
					batsmanMap.put("Out", "");
				}
				try {
					batsmanMap.put("BatsmanURL", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH
							+ "[" + j + "]/div[@class='wrap batsmen']/div[1]/a")).getAttribute("href"));
				} catch (Exception e) {
					batsmanMap.put("BatsmanURL", "");
				}
				try {
					batsmanMap.put("Runs", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "["
							+ j + "]/div[@class='wrap batsmen']/div[3]")).getText());
				} catch (Exception e) {
					batsmanMap.put("Runs", "");
				}
				try {
					batsmanMap.put("Balls", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH + "["
							+ j + "]/div[@class='wrap batsmen']/div[4]")).getText());
				} catch (Exception e) {
					batsmanMap.put("Balls", "");
				}

				if (header_size <= 8) {
					try {
						batsmanMap.put("Four", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH
								+ "[" + j + "]/div[@class='wrap batsmen']/div[5]")).getText());
					} catch (Exception e) {
						batsmanMap.put("Four", "");
					}
					try {
						batsmanMap.put("Six", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH
								+ "[" + j + "]/div[@class='wrap batsmen']/div[6]")).getText());
					} catch (Exception e) {
						batsmanMap.put("Six", "");
					}
					try {
						batsmanMap.put("StrikeRate", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]"
								+ BATSMAN_XPATH + "[" + j + "]/div[@class='wrap batsmen']/div[7]")).getText());
					} catch (Exception e) {
						batsmanMap.put("StrikeRate", "");
					}

				} else {
					try {
						batsmanMap.put("Four", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH
								+ "[" + j + "]/div[@class='wrap batsmen']/div[6]")).getText());
					} catch (Exception e) {
						batsmanMap.put("Four", "");
					}
					try {
						batsmanMap.put("Six", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + BATSMAN_XPATH
								+ "[" + j + "]/div[@class='wrap batsmen']/div[7]")).getText());
					} catch (Exception e) {
						batsmanMap.put("Six", "");
					}
					try {
						batsmanMap.put("StrikeRate", driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]"
								+ BATSMAN_XPATH + "[" + j + "]/div[@class='wrap batsmen']/div[8]")).getText());
					} catch (Exception e) {
						batsmanMap.put("StrikeRate", "");
					}

				}
				batsmenList.add(batsmanMap);
				batsmanMap = null;
			}
			logger.info("Batting Data fetched for Team " + i + " in Match ID : " + match_id);
		}
		return batsmenList;
	}

	public static List<HashMap<String, String>> getBowlerList(String series_id, String match_id) {
		List<HashMap<String, String>> bowlerList = new ArrayList<HashMap<String, String>>();
		int Innings_Size = driver.findElements(By.xpath(BASE_XPATH)).size();
		for (int i = 1; i <= Innings_Size; i++) {
			String team = driver.findElement(By.xpath(BASE_XPATH + "[" + i + "]" + TEAM_XPATH)).getText();
			logger.info("Bowling Data is being fetched for " + team);
			int batsman_size = driver.findElements(By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH)).size();
			for (int j = 1; j <= batsman_size; j++) {
				HashMap<String, String> bowlersMap = new HashMap<String, String>();
				bowlersMap.put("Team", team);
				bowlersMap.put("Innings", String.valueOf(i));
				bowlersMap.put("Series_ID", series_id);
				bowlersMap.put("Match_ID", match_id);
				bowlersMap.put("Bowler", "");
				bowlersMap.put("BowlerURL", "");
				bowlersMap.put("Maiden", "");
				bowlersMap.put("Run", "");
				bowlersMap.put("Wkt", "");
				bowlersMap.put("Econ", "");
				bowlersMap.put("NB", "");
				bowlersMap.put("Wide", "");
				bowlersMap.put("Dot", "");
				bowlersMap.put("Four", "");
				bowlersMap.put("Six", "");
				int columnSize = driver
						.findElements(By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td")).size();
				try {
					bowlersMap.put("Bowler",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[1]/a"))
									.getText());
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("BowlerURL",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[1]/a"))
									.getAttribute("href"));
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("Over",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[3]"))
									.getText());
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("Maiden",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[4]"))
									.getText());
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("Run",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[5]"))
									.getText());
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("Wkt",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[6]"))
									.getText());
				} catch (Exception e) {

				}
				try {
					bowlersMap.put("Econ",
							driver.findElement(
									By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[7]"))
									.getText());
				} catch (Exception e) {

				}

				if (columnSize > 10) {
					try {
						bowlersMap.put("Dot",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[8]"))
										.getText());
					} catch (Exception e) {

					}
					try {
						bowlersMap.put("Four",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[9]"))
										.getText());
					} catch (Exception e) {

					}
					try {
						bowlersMap.put("Six",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[10]"))
										.getText());
					} catch (Exception e) {

					}
					try {
						bowlersMap.put("Wide",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[11]"))
										.getText());
					} catch (Exception e) {

					}
					try {
						bowlersMap.put("NB",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[12]"))
										.getText());
					} catch (Exception e) {

					}

				} else {
					try {
						bowlersMap.put("Wide",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[8]"))
										.getText());
					} catch (Exception e) {

					}
					try {
						bowlersMap.put("NB",
								driver.findElement(
										By.xpath(BASE_XPATH + "[" + i + "]" + BOWLER_XPATH + "[" + j + "]/td[9]"))
										.getText());
					} catch (Exception e) {

					}
					bowlersMap.put("Dot", "");
					bowlersMap.put("Four", "");
					bowlersMap.put("Six", "");
				}
				bowlerList.add(bowlersMap);
				bowlersMap = null;
			}
			logger.info("Bowling Data fetched for Team " + i + " in Match ID : " + match_id);
		}
		return bowlerList;
	}
}

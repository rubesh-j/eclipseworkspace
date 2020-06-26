package com.cricstats.seriesextractor.uiPages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class T20SeriesPage extends ExtractData {

	public static String BASE_XPATH = "//section[@class='series-summary-wrap'][1]/section[contains(@class,'series-summary-block')][";
	public static String Teams_XPATH = "]//div[@class='series-info']/descendant::div[@class='teams']";
	public static String Date_XPATH = "]//div[@class='series-info']/descendant::div[@class='date-location']";
	public static String Result_XPATH = "]//div[@class='series-info']/descendant::div[@class='result-info']";
	public static String MATCH_BASE_XPATH = "]//section[contains(@class,'default-match-block')][";
	public static String Match_Info_XPATH = "]/div[@class='match-info']";
	public static String Innings_1_XPATH = "]/div[@class='innings-info-1']";
	public static String Innings_2_XPATH = "]/div[@class='innings-info-2']";
	public static String Match_Status_XPATH = "]/div[@class='match-status']/span";
	public static String ScoreCard_URL_XPATH = "]/div[@class='match-articles']/a";
	
	
	public static List<HashMap<String, String>> getSeriesListInfo() {
		List<HashMap<String, String>> seriesInfoListMap = new ArrayList<HashMap<String, String>>();
		try {
			List<WebElement> seriesInfoList = driver.findElements(By.xpath(
					"//section[@class='series-summary-wrap'][1]/section[contains(@class,'series-summary-block')]"));
			logger.info("Total number of Series : " + seriesInfoList.size());
			for (int i = 1; i <= seriesInfoList.size(); i++) {
				HashMap<String, String> seriesInfoMap = new HashMap<String, String>();
				seriesInfoMap.put("Team", driver.findElement(By.xpath(BASE_XPATH + i + Teams_XPATH)).getText()
						+ driver.findElement(By.xpath(BASE_XPATH + i + Date_XPATH)).getText());
				seriesInfoMap.put("Result", driver.findElement(By.xpath(BASE_XPATH + i + Result_XPATH)).getText());
				seriesInfoListMap.add(seriesInfoMap);
				seriesInfoMap = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Series Data to be inserted" + seriesInfoListMap);
		return seriesInfoListMap;
	}

	public static void getEachMatchInfo() {
		// get the total list of series
		List<WebElement> seriesInfoList = driver.findElements(By
				.xpath("//section[@class='series-summary-wrap'][1]/section[contains(@class,'series-summary-block')]"));
		System.out.println("Total number of Series : " + seriesInfoList.size());
		for (int i = 1; i <= seriesInfoList.size(); i++) {
			
			String team =  driver.findElement(By.xpath(BASE_XPATH + i + Teams_XPATH)).getText()
								+ driver.findElement(By.xpath(BASE_XPATH + i + Date_XPATH)).getText();
			driver.findElement(By.xpath(BASE_XPATH + i + "]//div[@class='series-info']/following-sibling::a")).click();
			// to get the list of each match under the series
			List<WebElement> matchInfoList = driver
					.findElements(By.xpath(BASE_XPATH + i + "]//section[contains(@class,'default-match-block')]"));
			logger.info("Total number of matches in " + team + " : " + matchInfoList.size());
			for(int j = 1 ; j <= matchInfoList.size(); j++)
			{
				logger.info("Result of Match "+j +" : " + driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + Match_Status_XPATH)).getText());
				HashMap<String, String> seriesInfoMap = new HashMap<String, String>();
				seriesInfoMap.put("SeriesName", team );
				seriesInfoMap.put("Match", driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + Match_Info_XPATH)).getText());
				seriesInfoMap.put("Innings 1", driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + Innings_1_XPATH)).getText());
				seriesInfoMap.put("Innings 2", driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + Innings_2_XPATH)).getText());
				seriesInfoMap.put("Match Status", driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + Match_Status_XPATH)).getText() );
				seriesInfoMap.put("ScorecardURL", driver.findElement(By.xpath(BASE_XPATH + i + MATCH_BASE_XPATH + j + ScoreCard_URL_XPATH)).getAttribute("href") );
				seriesScorecardsList.add(seriesInfoMap);
				seriesInfoMap = null;	
			}
		}
		logger.info("Total Number of matches extracted is " +seriesScorecardsList.size());
		logger.info(seriesScorecardsList);
	}
}

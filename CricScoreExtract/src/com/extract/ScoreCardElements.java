package com.extract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScoreCardElements {
	WebDriver driver;
	By teamnames = By.xpath("//a[@class='app_partial']/span[1]");
	By bowlingHeader = By.xpath("//div[@class='scorecard-section bowling']//thead/tr[1]/th");
	By bowlersElements = By.xpath("//div[@class='scorecard-section bowling']//tbody/tr");
	By batsmenelements = By.xpath("//div[@class='col-b']//div[@class='flex-row']/div[@class='wrap batsmen']");
	int i = 0, j = 0;
	String[] headerBattingArray = { "Runs", "Balls", "Fours", "Sixes", "StrikeRate" };
	String[] headerBattingExcel = { "Batsman", "WickeInfo", "Runs", "Balls", "Fours", "Sixes", "StrikeRate" };
	String[] headerBowlingExcel = { "Bowler", "Overs", "Maiden", "Runs", "Wickets", "Economy", "Dots", "Fours", "Sixes",
			"Wides", "NoBall" };

	public ScoreCardElements(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> getTeams(String outputfilename) {
		List<WebElement> teamlist = driver.findElements(teamnames);
		HashMap<String, String> teammap = new HashMap<String, String>();
		i = 0;
		teamlist.forEach(team -> {
			if (!team.getText().equals("")) {
				System.out.println("Playing Teams : " + team.getText());
				// create a workbook and header for teh teams
				Workbook workbook = null;
				try {
					workbook = WorkbookFactory.create(new FileInputStream(outputfilename));
				} catch (Exception e) {
					e.printStackTrace();
				}
				String battingsheetName = "";
				String bowlingsheetName = "";
				if(team.getText().replaceAll(" ", "").length() > 10)
				{
					 battingsheetName = team.getText().replaceAll(" ", "").substring(0, 10) + "-Bat";
					 bowlingsheetName = team.getText().replaceAll(" ", "").substring(0, 10) + "-Bowl";
				}
				else{
					 battingsheetName = team.getText().replaceAll(" ", "")+ "-Bat";
					 bowlingsheetName = team.getText().replaceAll(" ", "")+ "-Bowl";	
				}
				
				Sheet batSh = workbook.createSheet(battingsheetName);
				Sheet bowlSh = workbook.createSheet(bowlingsheetName);
				// Create a header row
				creatHeader(headerBattingExcel, batSh);
				creatHeader(headerBowlingExcel, bowlSh);
				teammap.put("Team " + i, team.getText());
				System.out.println("****************************Batsmen Details**********************");
				getBatsmenDetails(team.getText(), battingsheetName, workbook);
				System.out.println("****************************Bowler Details**********************");
				getBowlerDetails(team.getText(), bowlingsheetName, workbook);
				try {
					FileOutputStream opFile = new FileOutputStream(outputfilename);
					workbook.write(opFile);
					opFile.close();
				} catch (Exception e) {
					System.out.println("Issue in Creating output");
					e.printStackTrace();
				}
			}
			i++;
		});
		return teammap;
	}

	public void getBatsmenDetails(String teamName, String sheetName, Workbook workbook) {
		HashMap<String, String> excelDataMap = new HashMap<String, String>();
		List<WebElement> batsmenlist = driver.findElements(batsmenelements);
		Sheet sheet = workbook.getSheet(sheetName);
		batsmenlist.forEach(batsmen -> {
			excelDataMap.clear();
			WebElement eachBatsmen = batsmen.findElement(By.xpath("div[@class='cell batsmen']/a"));
			String teamname = eachBatsmen.findElement(By.xpath("ancestor::li[@class='accordion-item']/div[1]/a"))
					.getText();
			if (teamname.contains(teamName)) {
				System.out.println("Last Row :" + sheet.getLastRowNum());
				Row dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
				System.out.println("Writing in : " + dataRow.getRowNum());
				excelDataMap.put("TeamName", teamName);
				WebElement wicketInfo;
				excelDataMap.put("Batsman", eachBatsmen.getText());
				ArrayList<String> wicketinfo = new ArrayList<String>();
				ArrayList<String> data = new ArrayList<String>();
				// to get the wicket info
				try {
					String wicket = "";
					wicketInfo = batsmen.findElement(By.xpath("div[@class='cell commentary']"));
					if (wicketInfo.getText().equals("")) {
						wicketInfo = batsmen.findElement(By.xpath("div[@class='cell commentary']/a"));
						wicket = wicketInfo.getText();
					} else {
						wicketinfo.add(wicketInfo.getText());
						wicket = wicketInfo.getText();
					}
					excelDataMap.put("WicketInfo", wicket);
				} catch (NoSuchElementException e) {
					e.printStackTrace();
					excelDataMap.put("WicketInfo", "");
				}
				// to get batsmen playing info
				List<WebElement> batsmenStats = batsmen.findElements(By.xpath("div[@class='cell runs']"));

				j = 0;
				batsmenStats.forEach(stats -> {
					data.add(stats.getText());
					excelDataMap.put(headerBattingArray[j], stats.getText());
					j++;
				});
				writeData(excelDataMap, sheet, dataRow);
				System.out.println(excelDataMap);
			}
		});
	}

	public void creatHeader(String[] headerArray, Sheet sh) {
		Row row = sh.createRow(0);
		for (int k = 0; k < headerArray.length; k++) {
			row.createCell(k).setCellValue(headerArray[k]);
		}

	}

	// function to write the value to the excel
	public void writeData(HashMap<String, String> excelMap, Sheet sh, Row dataRow) {
		int lastCell = sh.getRow(0).getLastCellNum();
		for (int a = 0; a < lastCell; a++) {
			String cellval = sh.getRow(0).getCell(a).getStringCellValue();
			dataRow.createCell(a).setCellValue(excelMap.get(cellval));
		}
	}

	public void getBowlerDetails(String teamName, String sheetName, Workbook workbook) {
		HashMap<String, String> excelDataMap = new HashMap<String, String>();
		List<WebElement> bowlerslist = driver.findElements(bowlersElements);
		Sheet sheet = workbook.getSheet(sheetName);
		bowlerslist.forEach(bowler -> {
			String teamname = bowler.findElement(By.xpath("ancestor::li[@class='accordion-item']/div[1]/a")).getText();
			excelDataMap.clear();
			if (teamname.contains(teamName)) {
				excelDataMap.clear();
				System.out.println("Last Row :" + sheet.getLastRowNum());
				Row dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
				System.out.println("Writing in : " + dataRow.getRowNum());
				excelDataMap.put("TeamName", teamName);
				excelDataMap.put("Bowler", bowler.getText());
				List<WebElement> bowlerStats = bowler.findElements(By.xpath("td"));
				System.out.println(bowlerStats.size());
				j = 1;
				for (int k = 2; k < bowlerStats.size()-1; k++) {
					System.out.println(headerBowlingExcel[j]);
					System.out.println(bowlerStats.get(k).getText());
					excelDataMap.put(headerBowlingExcel[j], bowlerStats.get(k).getText());
					j++;
				}
				System.out.println(excelDataMap);
				writeData(excelDataMap, sheet, dataRow);
			}
		});

	}
}

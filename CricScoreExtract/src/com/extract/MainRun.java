package com.extract;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class MainRun {

	public static void main(String[] args)
	{
		String inputurl = "";
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		inputurl = JOptionPane.showInputDialog("Enter the URL of the Scorecard");
		System.out.println(inputurl);
		// to create the output file
		HashMap<String , String>  teammap = new HashMap<String,String>();
		Date start = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");
		String stringDate =dateformat.format(start);
		if(!new File("./Output").exists())
		{
			new File("./Output").mkdir();
		}
		String outputfilename = "./Output\\Cricket_MatchInfo_" + stringDate+ ".xlsx";
		System.out.println(outputfilename);
		Workbook outputworbook = new XSSFWorkbook(); 
		try{
			FileOutputStream opFile = new FileOutputStream(outputfilename);
			outputworbook.write(opFile);
			opFile.close();
		}
		catch(Exception e){
			System.out.println("Issue in Creating output");
			e.printStackTrace();
		}
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get(inputurl);
		ScoreCardElements scorecard = new ScoreCardElements(driver);
		teammap = scorecard.getTeams(outputfilename);		
		System.out.println(teammap);
						
	}
}

package com.stats11.main;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.stats11.dao.DatabaseService;

public class UpdateURL {
	public static ArrayList<String> errorPlayers = new ArrayList<String>();
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, AWTException, InterruptedException {
		Connection conn = DatabaseService.connect();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ResultSet rs = DatabaseService.getPlayerURL(conn);
		while (rs.next()) {
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(1));
			//WebDriver driver = new ChromeDriver();
			WebDriver driver = new HtmlUnitDriver();
			// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			driver.get(rs.getString(2));
			
			try {
			WebElement playerImg = driver.findElement(By.xpath("//div[@class=\"pnl490M\"]/div[2]/div[2]/img"));
			
			System.out.println(playerImg.getAttribute("src"));
			driver.navigate().to(playerImg.getAttribute("src"));
			Thread.sleep(2000);
			//System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("http://p.imgci.com"))
			{
			System.out.println(driver.getCurrentUrl());
			DatabaseService.updateUrl(conn, driver.getCurrentUrl(), rs.getString(1));
			}
			}
			catch(NoSuchElementException e)
			{
				System.out.println("No Image");
				errorPlayers.add(rs.getString(1));
			}
			/*Actions a1 = new Actions(driver);
			a1.contextClick(playerImg).build().perform();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
			Iterator<String> it = driver.getWindowHandles().iterator();
			while (it.hasNext()) {
				String chl = it.next();
				System.out.println(chl);
				driver.switchTo().window(chl);
				if(driver.getCurrentUrl().contains("http://p.imgci.com"))
				{
				System.out.println(driver.getCurrentUrl());
				DatabaseService.updateUrl(conn, driver.getCurrentUrl(), rs.getString(1));
				}
			}*/
			driver.quit();
		}
		conn.close();
		System.out.println(errorPlayers);
	}
}


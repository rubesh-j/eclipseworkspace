package com.cricstats.seriesextractor.uiPages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GetPlayerImgUrl {

	public static HashMap<String, String> getPlayerImg(HashMap<String, String> playerDetails) {
		HashMap<String, String> getPlayerImgMap = new HashMap<String, String>();
		playerDetails.forEach((playerid, playerurl) -> {
			WebDriver driver = new HtmlUnitDriver();
			// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			try {
				driver.get(playerurl);
				try {
					WebElement playerImg = driver.findElement(By.xpath("//div[@class=\"pnl490M\"]/div[2]/div[2]/img"));

					// System.out.println(playerImg.getAttribute("src"));
					driver.navigate().to(playerImg.getAttribute("src"));
					Thread.sleep(2000);
					// System.out.println(driver.getCurrentUrl());
					if (driver.getCurrentUrl().contains("p.imgci.com")) {
						System.out.println(playerid + " - " + driver.getCurrentUrl());
						getPlayerImgMap.put(playerid, driver.getCurrentUrl());
					}
				} catch (NoSuchElementException e) {
					System.out.println("No Image Available" + playerid);
					getPlayerImgMap.put(playerid, "Image not available");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {

			}

			finally {
				driver.close();
			}

		});

		System.out.println(getPlayerImgMap);
		return getPlayerImgMap;
	}
}

package com.rubesh.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class App {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "MyAndroid");
		cap.setCapability("udid", "ZY32278R3H");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		AppiumDriver driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		System.out.println(driver.findElementById("com.google.android.calculator:id/result_preview").getText());
	}
}

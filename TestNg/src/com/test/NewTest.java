package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	
	@Test(groups = { "test1" })
	public void test1() {
		System.out.println("Test1");
		WebDriverWait wait = new WebDriverWait(new ChromeDriver(), 30);
		wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver t) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait1= new WebDriverWait(driver, 10);      
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("dat");
	}

	@Test(groups = { "test3" })
	public void test2() {
		System.out.println("Test2");
	}

	@Test(groups = { "test3" })
	public void test3() {
		System.out.println("Test3");
	}

	@DataProvider(name = "test2Data")
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> arrayObj = new ArrayList<Object[]>();
		arrayObj.add(new Object[]{"a","b","c"});
		arrayObj.add(new Object[]{"b","c","b"});
		return  arrayObj.iterator();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

}

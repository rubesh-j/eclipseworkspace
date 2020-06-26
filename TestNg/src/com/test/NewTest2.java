package com.test;

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

public class NewTest2 {
	
  @Test(dataProvider = "test2Data" , dataProviderClass = NewTest.class, groups = { "test1" })
  public void f(String q, String w, String e) {
	  System.out.println(q + "-" + w + "-" +e);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("F-beforeMethod2");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("F-afterMethod2");
  }
  
  @DataProvider (name="Data")
  public Object[][] getData(){

	  return new Object[][] {
		  {"a","b","c"},
		  {"c","v","b"},
      };
  }  
  @DataProvider(name="SearchProvider")
  public static Object[][] getDataFromDataprovider(){
      return new Object[][] {
          { "Guru99", "India" ,"New" },
          { "Krishna", "UK" ,"New" },
          { "Bhupesh", "USA", "New" }
      };
  }
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass2");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest2");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite2");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite2");
	}

  }



package com.factory;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DataProviderExample {
	

		

		@Test(dataProvider="dp")
		public void methodOne(int num,String data) {
			System.out.println("Runing in thread " + Thread.currentThread().getId());
			System.out.println("This is method one");
			System.out.println(num);
			System.out.println(data);
			
		}

		@Test(dataProvider="dp")
		public void methodtwo(int num,String data) {
			System.out.println("Runing in thread " + Thread.currentThread().getId());
			System.out.println("This is method two");
			System.out.println(num);
			System.out.println(data);
		}
		
		@DataProvider
		public static Object[][] dp() {
			return new Object[][] { { 1, "one" }, { 2, "two" }};
		}

		@BeforeClass
		public void beforeClass() {
			System.out.println("@BeforeClass");
		}
		

		@AfterClass
		public void afterClass() {
			System.out.println("@AfterClass");
		}

	

}

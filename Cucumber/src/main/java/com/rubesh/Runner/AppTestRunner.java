package com.rubesh.Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

/**
 * Unit test for simple App.
 */
@CucumberOptions(features = { "src/main/java/feature" }, glue = { "com.rubesh" }, dryRun = false, plugin = { "pretty",
		"html:target/cucumber-reports", "rerun:target/rerun.txt"}, monochrome = true )
public class AppTestRunner extends CustomTestNGRunner {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest Scenariologger;
	public static ExtentTest steplogger;
	public static Map<String, String> featureMap = new HashMap();
	public static String currentFeature,newFeature ;
	static {
		System.out.println("This executed before all the class");
		TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(AppTestRunner.class);
		Object[][] data = testNGCucumberRunner.provideScenarios();
		for (int i = 0; i < data.length; i++) {
			featureMap.put(((PickleWrapper) data[i][0]).toString().trim().replaceAll("\"", ""),
					((FeatureWrapper) data[i][1]).toString().trim().replaceAll("\"", ""));
		}
		System.out.println(featureMap);
		currentFeature = "";
	}

	@BeforeTest
	public void intializeMethod() {
		htmlReporter = new ExtentHtmlReporter("Extent.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Sample Test Report");
		htmlReporter.config().enableTimeline(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("TestName", "Cucumber Test");
		extent.setSystemInfo("Author", "Rubesh");
		
		extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
		
		System.out.println("Executes Before Test");
	}

	@Before
	public void beforeScenario(Scenario scenario) throws ClassNotFoundException {
		
		newFeature = featureMap.get(scenario.getName().replaceAll("\"", ""));
		
		System.out.println(newFeature);
		/*System.out.println(newFeature);
		if(!currentFeature.equals(newFeature))
		{
		logger = extent.createTest(Feature.class, featureMap.get(scenario.getName().replaceAll("\"", "")));
		currentFeature = featureMap.get(scenario.getName().replaceAll("\"", ""));
		}
		Scenariologger = logger.createNode(new GherkinKeyword("Scenario"), scenario.getName()) ;*/
		logger = extent.createTest(scenario.getName()).assignCategory(newFeature);
		logger.assignAuthor("Rubesh");
		logger.assignDevice("Windows");
		ArrayList data = new ArrayList<>();
		
		System.out.println("Executes Before Scenario : " + scenario.getName());
	}

	@BeforeStep
	public void beforeStep() {
		
		System.out.println("Executes Before Step: ");
	}

	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.getStatus().equals(Status.FAILED))
		{
			steplogger.fail("TestCase Failed");
			
		}
		System.out.println("Executes after Scenario");
	}

	@AfterStep
	public void aftereStep() {
		System.out.println("Executes after step");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Executes after test");
		extent.flush();
	}
}

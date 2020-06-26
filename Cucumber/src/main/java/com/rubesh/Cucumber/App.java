package com.rubesh.Cucumber;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.rubesh.Runner.AppTestRunner;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Hello world!
 *
 */
public class App {

	@Given("I want to write a step with {string}")
	public void i_want_to_write_a_step_with_name2(String name) throws ClassNotFoundException {
		ExtentTest newTest = AppTestRunner.logger.createNode("@Given(I want to write a step with " + name + ")");
		newTest.log(Status.INFO, "i_want_to_write_a_step_with_name2");
		newTest.log(Status.INFO, name);
		// Write code here that turns the phrase above into concrete actions
		//ExtentTest givenTest = AppTestRunner.logger.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "I want to write a step with " +name );
		String java = "Data;";
		System.out.println(name);
		//ExtentTest newTest = AppTestRunner.Scenariologger.createNode(new GherkinKeyword("Given"),"@Given(I want to write a step with " + name + ")");
		//newTest.info( "i_want_to_write_a_step_with_name2");
		newTest.pass( name);
		//givenTest.info("This is information for Given");
		//givenTest.log(Status.PASS, name);
		
	}

	

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) throws ClassNotFoundException {
		ExtentTest newTest = AppTestRunner.logger.createNode("@When(\"I check for the " + int1 + " in step\")");
		newTest.log(Status.INFO, "i_check_for_the_in_step");
		newTest.log(Status.INFO, String.valueOf(int1));
		newTest.log(Status.PASS, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		// Write code here that turns the phrase above into concrete actions
		//ExtentTest whenTest = AppTestRunner.logger.createNode( (Class<? extends IGherkinFormatterModel>) When.class, "I check for the "+int1+" in step ");
		System.out.println(int1);
	}
	
	/*@When("I check for the user in step")
	public void i_check_for_the_in_step(DataTable data) throws ClassNotFoundException {
		List<Book> book = new ArrayList<Book>();
		book = data.asList(Book.class);
		book.forEach(i->{
		ExtentTest newTest = AppTestRunner.logger.createNode("@When(\"I check for the user in step\")");
		newTest.log(Status.INFO, "i_check_for_the_in_step");
	//	newTest.log(Status.INFO, String.valueOf(int1));
		newTest.log(Status.PASS, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		// Write code here that turns the phrase above into concrete actions
		//ExtentTest whenTest = AppTestRunner.logger.createNode( (Class<? extends IGherkinFormatterModel>) When.class, "I check for the "+int1+" in step ");
		//System.out.println(int1);
		
		
		
		newTest.log(Status.INFO,i.getTitle());
		Assert.fail();
		});
	}*/
	
	@When("I check for the title in step")
	public void i_check_for_the_in_step(DataTable dataTable) throws ClassNotFoundException {
		
		List<Map<String,String>> data = dataTable.asMaps();
		for(Map<String,String> eachData : data)
		{
			AppTestRunner.steplogger = AppTestRunner.logger.createNode("@When(\"I check for the user in step\")");
			AppTestRunner.steplogger.log(Status.INFO, "i_check_for_the_in_step");
		//	newTest.log(Status.INFO, String.valueOf(int1));
			AppTestRunner.steplogger.log(Status.PASS, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
			// Write code here that turns the phrase above into concrete actions
			//ExtentTest whenTest = AppTestRunner.logger.createNode( (Class<? extends IGherkinFormatterModel>) When.class, "I check for the "+int1+" in step ");
			//System.out.println(int1);
			
			
			
			AppTestRunner.steplogger.log(Status.INFO,eachData.get("title"));
			AppTestRunner.steplogger.log(Status.INFO, "Expected : The Lion, the Witch and the Wardrobe");
			Assert.assertEquals(eachData.get("title"), "The Lion, the Witch and the Wardrobe");
			
		}
		
	}

	

	@Then("I verify the {string} in step")
	public void i_verify_the_Fail_in_step(String status) throws ClassNotFoundException {
		// Write code here that turns the phrase above into concrete actions
		ExtentTest newTest = AppTestRunner.logger.createNode("@Then(\"I verify the " + status + "  in step\")");
		newTest.pass("i_verify_the_Fail_in_step");
		newTest.pass(status);
		System.out.println(status);
	}
}

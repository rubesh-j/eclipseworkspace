package com.rubesh.Cucumber;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

public class TestMethod {

	@Test
	public void testNgMethod() {
		System.out.println("This is TestNG Method");
		RestAssured.baseURI ="https://maps.googleapis.com";
		RestAssured.requestSpecification = new RequestSpecBuilder().addParam("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").build();
		RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
		
		
		Response respose =  
		given().
	       param("location","-33.8670522,151.1957362").
	       param("radius","500").
	     when().
	     	get("/maps/api/place/nearbysearch/json").
	     then().
	     	log().all().
	     	extract().response();
		
		System.out.println("Time : : " + respose.getTimeIn(TimeUnit.SECONDS));
	//	System.out.println(respose.asString());
			
	}
}

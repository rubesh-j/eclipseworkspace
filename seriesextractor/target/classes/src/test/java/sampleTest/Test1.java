package sampleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import service.Student;

public class Test1 {

	
	@Test
	public void studentTest() {
		Student st1 = new Student("Rubesh","jru1qap","Java Developer");
		Assert.assertEquals(st1.getName(), "Rubesh");
	}

}

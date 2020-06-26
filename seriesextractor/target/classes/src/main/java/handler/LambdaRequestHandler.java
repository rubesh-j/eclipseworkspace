package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.Student;

public class LambdaRequestHandler implements RequestHandler<String, String> {

	public String handleRequest(String input, Context context) {
		Student st1 = new Student("Rubesh","jru1qap","Java Developer");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(st1);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getLocalizedMessage();
			
		}
		return jsonString;
	}
	

}

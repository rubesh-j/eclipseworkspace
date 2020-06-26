import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class FizzBUzz {
public static void main(String[] args) {
	Student st1 = new Student("jru1qap","Rubesh","Java");
	
	ObjectMapper mapper = new ObjectMapper();
	String jsonString =  "";
	try {
		jsonString = mapper.writeValueAsString(st1);
	} catch (JsonProcessingException e) {
		e.printStackTrace();

		
	}
	System.out.println(jsonString);
	
}
}

class Student {
	private  String name;
	private  String id;
	private  String role;

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  String getId() {
		return id;
	}

	public  void setId(String id) {
		this.id = id;
	}

	public  String getRole() {
		return role;
	}

	public  void setRole(String role) {
		this.role = role;
	}

	public Student(String name, String id, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public Student(){
		
	}
}

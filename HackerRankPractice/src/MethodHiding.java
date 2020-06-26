
public class MethodHiding {

	public static void main(String[] args) {
		BaseClass base = new SubClass();
		SubClass sub = new SubClass();
		
		System.out.println("****************");
		base.data();
		base.basedata();
		System.out.println("****************");
		sub.data();
		sub.basedata();
		
	}
}

class BaseClass {
	public void data() {
		System.out.println("Non Static Base Class");
	}
	
	public static void basedata() {
		System.out.println(" Static Base Class");
	}
}

class SubClass extends BaseClass {
	@Override
	public void data() {
		System.out.println("Non Static Sub Class");
	}
	
	public static void basedata() {
		System.out.println(" Static Sub Class");
	}
}
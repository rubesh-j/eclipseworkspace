
public class Test {
 
	public void method() {
		System.out.println("Test");
		Float data = new Float("3.0");
		Integer d = new Integer(561892);
		System.out.println(d.toBinaryString(d));
		System.out.println(d.byteValue());
		System.out.println(data.byteValue() + data.intValue() + data.doubleValue());
	}
}

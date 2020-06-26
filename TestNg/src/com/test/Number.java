package com.test;

class Value {

	public void show() {
		System.out.println("this is Value class");
	}
}

class Data extends Value{
	
	
	public void show() {
		System.out.println("this is Data class");
	}
}

public class Number{
	
	public static void main(String[] args) {
		Value v1 = new Value();
		Value v = new Data();
		Data d = new Data();
	//	Data d1 = (Data) new Value();
		
		v.show();
		d.show();
		v1.show();
	}
}
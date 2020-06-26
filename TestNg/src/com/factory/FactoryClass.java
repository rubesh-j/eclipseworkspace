package com.factory;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory()
	public Object[] factoryMethod() {

		return new Object[] { new FactoryTest(1, "one"), new FactoryTest(2, "two") };

	}
}

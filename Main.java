package com.singleton;

public class Main {
	public static void main(String[] args) {
		SingletonEnum enum1=SingletonEnum.TESTINSTANCE;
		enum1.setValue(30);
		enum1.doWork();
	}
}

/*
Enum Singleton working, value = 30
*/
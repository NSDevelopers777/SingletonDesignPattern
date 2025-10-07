package com.singleton;

public enum SingletonEnum {
	TESTINSTANCE;

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void doWork() {
		System.out.println("Enum Singleton working, value = " + value);
	}
}

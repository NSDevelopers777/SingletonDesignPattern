package com.singleton;

import java.io.Serializable;

public class SafeSingleton1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final SafeSingleton1 instance = new SafeSingleton1();

	private SafeSingleton1() {

	}

	public static SafeSingleton1 getInstance() {
		return instance;
	}

	public Object readResolve() {
		return instance;
	}

}

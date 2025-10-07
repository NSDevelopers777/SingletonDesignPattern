package com.singleton;

import java.io.Serializable;

public class BrokenSingleton implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final BrokenSingleton INSTANCE = new BrokenSingleton();
	
	private BrokenSingleton() {
		
	}
	
	public static BrokenSingleton getInstance() {
		return INSTANCE;
	}
}

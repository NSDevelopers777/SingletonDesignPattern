package com.singleton;

public class SingletonLazySync {
	private static SingletonLazySync instance;

	private SingletonLazySync() {

	}

	public static SingletonLazySync getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingletonLazySync();
		}
		return instance;
	}

	public void doSomething() {
		System.out.println("Something is being done...");
	}

	public static void main(String args[]) {
		Runnable task = () -> {
			SingletonLazySync test = SingletonLazySync.getInstance();
			System.out.println(test.hashCode());
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);

		t1.start();
		t2.start();
		t3.start();
	}
}

/*
 * 
899750321
1478816384
438163067

Different hashcode shows not thread safe

 */

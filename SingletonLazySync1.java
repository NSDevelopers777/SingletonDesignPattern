package com.singleton;

public class SingletonLazySync1 {
	private static SingletonLazySync1 instance;

	private SingletonLazySync1() {
	}

	public synchronized static SingletonLazySync1 getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingletonLazySync1();
		}
		return instance;
	}

	public void doSomething() {
		System.out.println("Something is being done...");
	}

	public static void main(String args[]) {
		Runnable task = () -> {
			SingletonLazySync1 test = SingletonLazySync1.getInstance();
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
O/P
1390189040
1390189040
1390189040
*/


package com.singleton;

public class AppConfig {
	// Because of static field it is thread-safe. 
	
	private static final AppConfig INSTANCE = new AppConfig();

	private String appName;
	private String dbUrl;
	private String version;

	private AppConfig() {
		this.appName = "MyPortfolioApp";
		this.dbUrl = "jdbc:mysql://localhost:3306/portfolio_db";
		this.version = "1.0.0";
	}

	public static AppConfig getInstance() {
		return INSTANCE;
	}

	public void showInstance() {
		System.out.println(appName);
		System.out.println(dbUrl);
		System.out.println(version);
	}

	public static void main(String args[]) {
		AppConfig config = AppConfig.getInstance();
		config.showInstance();
	}
}

/*
O/P
MyPortfolioApp
jdbc:mysql://localhost:3306/portfolio_db
1.0.0
*/

/*
In Java, class loading and static initialization are handled by the JVM — and that process is guaranteed to be thread-safe.

That means:

When the JVM loads your class SingletonEager,

It initializes all its static fields (INSTANCE here)

In a synchronized, one-time, thread-safe manner — before any thread can use it.

👉 Only one thread can initialize a class at a time.
Once initialization is done, all threads see the same initialized instance.
*/
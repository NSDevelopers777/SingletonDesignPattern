package com.singleton;

public class EagerInitialization {
	private static EagerInitialization eager = new EagerInitialization();

	private EagerInitialization() {
		// In case anyone tries to break in through reflection.
		if (eager != null) {
			throw new IllegalStateException("Illegal State of the object...");
		}
	}

	public static EagerInitialization getInstance() {
		return eager;
	}

	public void doSomething() {
		System.out.println("Some work has been done here...");
	}

	public static void main(String args[]) {
		EagerInitialization test = EagerInitialization.getInstance();
		test.doSomething();
	}
}

/* O/P
 * Some work has been done here...
*/

/* Pros:
 * Simple,Thread Safe
 * 
 * Cons:
 * Instance created even if never used.
 *  
 */


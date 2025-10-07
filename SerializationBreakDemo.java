package com.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationBreakDemo {
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
		BrokenSingleton s1 = BrokenSingleton.getInstance();

		// Serialize to file
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"));
		out.writeObject(s1);
		out.close();

		// Deserialize from file
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"));
		BrokenSingleton s2 = (BrokenSingleton) in.readObject();
		in.close();

		System.out.println("s1 hashcode: " + s1.hashCode());
		System.out.println("s2 hashcode: " + s2.hashCode());
		System.out.println("Same instance: " + (s1 == s2));
	}
}

/*
 * s1 hashcode: 193064360
s2 hashcode: 1299641336
Same instance: false
*/

package com.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationBreakDemo1 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SafeSingleton1 s1 = SafeSingleton1.getInstance();

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Test.txt"));
		out.writeObject(s1);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Test.txt"));
		SafeSingleton1 s2=(SafeSingleton1) in.readObject();
		in.close();
		
		System.out.println("s1 hashcode: "+s1.hashCode());
		System.out.println("s2 hashcode: "+s2.hashCode());
		System.out.println("Same Instance? "+(s1==s2));
	}
}


/*
s1 hashcode: 193064360
s2 hashcode: 193064360
Same Instance? true
*/


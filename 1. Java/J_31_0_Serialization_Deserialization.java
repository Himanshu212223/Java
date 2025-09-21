/*
	Object Serialization
	____________________________________________________
	
	- Serialization is the process of converting an object into a byte stream.
		It can then saved into a file, sent over a network, stored in a database.
	- In Java, a class must implement the Serializable interface to allow serialization.
		Serializable is a marker interface (has no methods, just tells JVM that the 
		object can be serialized).
		
	Deserialization
	____________________________________________________
	
	- Deserialization is the reverse process → converting a byte 
		stream back into the original object.
	
	Classes used
	------------------------------
	1. ObjectOutputStream → to serialize (write object as bytes).
	2. ObjectInputStream → to deserialize (read object back from bytes).
	
	Note - 
	------------------------------
	- serialVersionUID → ensures version compatibility 
		(helps JVM check if class changed between serialization and deserialization).
	- transient keyword → prevents a field from being serialized. Example:
	- transient String password; // won't be saved in file
	- Serializable is marker interface → no methods, just tells JVM "this class can be serialized."

	Real-Life Uses -
	-------------------------------
	1. Save objects in files (like session data).
	2. Send objects across networks (like in RMI, socket programming).
	3. Store objects in caches or databases.

*/


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Step 1: Make class Serializable

class Student implements Serializable {
	private static final long serialVersionUID = 1L; // recommended

	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}


//	Main class 

public class J_31_0_Serialization_Deserialization {

	public static void main(String[] args) {

		try {
			
			//	Serialization - 
			
			Student stud1 = new Student("Allen", 34) ;
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\himan\\Desktop\\StudentStream.ser");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(stud1);
			
			oos.close();
			fos.close();
			
			System.out.println("Serialized the class object");

			//	De-Serialization - 
			
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\himan\\Desktop\\StudentStream.ser");
			
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream) ;
			
			Student stud2 = (Student) objectInputStream.readObject() ;

			System.out.println(stud2);
			
			objectInputStream.close();
			fileInputStream.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

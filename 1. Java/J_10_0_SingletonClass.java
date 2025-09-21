
/*	
	In object-oriented programming, a java singleton class is a class that can have only one object
	 (an instance of the class) at a time. After the first time, if we try to instantiate the Java 
	 Singleton classes, the new variable also points to the first instance created. So whatever 
	 modifications we do to any variable inside the class through any instance, affects the variable
	  of the single instance created and is visible if we access that variable through any variable 
	  of that class type defined.
	
*/


class Singleton {
    // Static variable reference of single_instance
    // of type Singleton
    private static Singleton single_instance = null;
 
    // Declaring a variable of type String
    public String s;
 
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }
 
    // Static method
    // Static method to create instance of Singleton class
    public static synchronized Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
 
        return single_instance;
    }
}



public class J_10_0_SingletonClass {
	
	
	public static void main(String args[]) {
		
			
	}
}

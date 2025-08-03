package learn.testing;


public class App 
{
    public static void main( String[] args )
    {
        Students stud1 = new Students(12, "Test Student");
        
        //	stud1.name("Test Student2");   --> This is not allowed as 
        //	Records and its attributes are immutable.
        
        //	Below are the Getters 
        System.out.println( stud1.rollNo() );
        System.out.println( stud1.name() );
    }
}

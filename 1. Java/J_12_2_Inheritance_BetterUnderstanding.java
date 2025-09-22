class Parent {
    public String name ;

    public void parentDetails() {
        System.out.println("This is the working parent method.");
    }

    public void details(){
        System.out.println("This is details method defined on Parent.");
    }

}




class Child extends Parent {

    public String name ;

//    @Override
    public void childDetails() {
        System.out.println("This is the working child method.");
    }

    @Override
    public void details(){
        System.out.println("This is details method defined on Child.");
    }

}




public class J_12_2_Inheritance_BetterUnderstanding {

    public static void main(String args[] ){


        Parent pChild = new Child() ;

        pChild.details();       //  This will work and will execute the child implementation

        pChild.parentDetails(); //  This will work and will try to get the details from the Parent Class

        //  pChild.childDetails() ;     //  --> ERROR  This woudln't work




    }

    
}




/*
    Understand the Behaviour First -
    ------------------------------------------------------

    - If a Parent and Child class have same method, then Code execute the Child class method.

    - If we try to call any method of Child (which is not there on Parent), then it fails to compile
        and give "Cannot Find Symbol" Compile Time Error.

   Why there is a difference in Behavior -
   -------------------------------------------------------

   1. When we define Parent pChild = new Child() ;
        - It creates a pChild object with Reference Type of Parent.

   2. now if we call - pChild.details();
        - Since Java uses Reference Type at Compile Time, it tried to look for details method on Parent
            and gets the declaration and definition on Parent hence the code gets compiled successfully.

        - During execution or Runtime, JVM sees the Object is actually of Child, hence it execute the
            details method implemented on Child Class.

    3. when we call - pChild.parentDetails();
        - Since Java uses Reference Type at Compile Time, it tried to look for parentDetails method on Parent
            and gets the declaration and definition on Parent hence the code gets compiled successfully.

        - During execution or Runtime, JVM sees the Object is actually of Child, and since Child is extending
            the Parent class and parent methods got inherited on Child, hence, the parentDetails of Parent
            now belongs to Child and well and get implemented successfully.


     4. when we call - pChild.childDetails() ;
        - Since Java uses Reference Type at Compile Time, it tried to look for childDetails method on Parent
            and since there is no such method declared or defined on Parent class, hence it fails at Compile
            Time only.

*/
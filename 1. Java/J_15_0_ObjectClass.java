
/*
	Object Class :-
	_____________________
	
	Every class in Java is directly or indirectly derived from the Object class. 
	If a class does not extend any other class then it is a direct child class of Object 
	and if extends another class then it is indirectly derived. Therefore the Object class 
	methods are available to all Java classes. Hence Object class acts as a root of the 
	inheritance hierarchy in any Java Program.
	
	Various Predefined Methods of objects are :-
	1. equals()   : It compares objects through memory address. We can override as per requirement.
	2. hashCode() : It generates 32-bit integer hash value using object's data. 
					It derives hash value according to memory address.
	3. toString() : It will return a string value of the object.
	4. getClass() : It will return the class detail.
	
	
	For proper usage of equals method, the different objects should have same hashCode.
	So, if the object's parameters have same value, and hashCode() also gives same value,
	then, equals() will return true.	
	toString will return string consists of name of class of object, followed by hexadecimal 
	hashcode of object.

*/

class Vehicles extends Object{
	public String name ;
	public int vehicleNo ;
	
	Vehicles(){}
	
	Vehicles(Vehicles obj){
		this.name = obj.name ;
		this.vehicleNo = obj.vehicleNo;
	}
	
	@Override
	public String toString() {
		return "The vehicle no is " + this.vehicleNo + " and the name is " + this.name ;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Vehicles veh = (Vehicles) obj;
		
		if(this.name == veh.name && this.vehicleNo == veh.vehicleNo) {
			return true ;
		}
		
		return false ;
	}
	
}



public class J_15_0_ObjectClass extends Animal {
	
	public static void main(String args[]) {
		
	Vehicles alto = new Vehicles();
	
	alto.name = "alto";
	alto.vehicleNo = 4 ;
	
	System.out.println(alto.toString());
	System.out.println(alto.hashCode());
	System.out.println(alto.equals(alto));
	System.out.println(alto.getClass());
		
	}
}

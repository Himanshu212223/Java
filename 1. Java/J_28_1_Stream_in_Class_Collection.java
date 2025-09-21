

import java.util.List;
import java.util.stream.Collectors;

class myData{
	public int Id ;
	public String name ;
	public int age ;
	
	myData(int Id, String name, int age){
		this.Id = Id ;
		this.name = name ;
		this.age = age ;
	}
};


public class J_28_1_Stream_in_Class_Collection {
public static void main(String [] args) {

	//	Suppose, we want to filter out the details of those whose age is >= 18 from a collection of list1.
	//	here, list1 is the main data collection, and we are storing the filtered data in list2.

	
	List<myData> list1 = List.of(
									new myData(1, "A", 12), 
									new myData(2, "B", 18), 
									new myData(3, "C", 22),
									new myData(4, "D", 50),
									new myData(5, "E", 15)
								);
	
	List<myData> list2 = list1.stream().filter((object) -> object.age >= 18 ).collect(Collectors.toList()) ;
	
	list2.forEach(e -> System.out.println(e.Id  + " " + e.name + " " + e.age));
	
	}
}

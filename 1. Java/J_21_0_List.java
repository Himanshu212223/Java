
/*
 	Collection Framework :
 	___________________________________
 	
 	2. List :-
	________________
	
	- List is ordered collection of elements.
	- List Interface can have 2 different classes as, ArrayList and LinkedList.
	- ArrayList provides random access, hence, fast but, removal of element takes time.
	- LinkedList provides sequential access from from front or rear, hence slow, but removal of element is easy.
	
 */



import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


class School implements Comparable<School>{
	public int srNo ;
	
	School(){}
	
	School(int srNo){
		this.srNo = srNo ;
	}
	
	
	@Override
	public int compareTo(School school) {
		//	for doing this, we have to implement the Comparable<>.
		if(this.srNo == school.srNo) {
			return 0 ;
		}
		else if(this.srNo > school.srNo) {
			return 1 ;
		}
		else {
			return -1;
		}
	}
};


public class J_21_0_List {
	public static void main(String [] args) {
		List<Integer> list1 = new ArrayList<>() ;
		List<Integer> list2 = new ArrayList<>() ;
		List<Integer> list3 = new LinkedList<>() ;
		List<School> listOfSchool = new ArrayList<>();	//	List of user Defined class objects.
		
		list1 = List.of(1, 2, 3, 4, 5, 6, 7) ;	//	This will insert immutable elements in list.
	
		//	to insert mutable elements in list, we use add method.
		list2.add(1) ;
		list2.add(2) ;
		list2.add(0, 5) ;	//	index, value is passed.
		list2.addAll(0, list1) ;	//	adding list1 elements at index 0.
		
		list3.add(1) ;
		list3.add(2) ;
		list3.add(0, 5) ;
		list3.addAll(list1) ;	//	adding the whole list1 elements.
		list3.addAll(1, list2) ;	//	adding list2 elements at index 1.
		
		listOfSchool.add(new School(3)) ;
		listOfSchool.add(new School(1)) ;
		listOfSchool.add(new School(2)) ;
		listOfSchool.addAll(listOfSchool) ;
		
		
		//----------- Printing the whole list -------------
		
		System.out.println("List1 is " + list1) ;
		System.out.println("ArrayList2 is " + list2) ;
		System.out.println("LinkedList3 is " + list3) ;
		System.out.println("List of user defined object : " + listOfSchool) ;	//	shows toString value.
		
		
		
		//---------- Different way to iterate the set --------------
		
		//	Method - 1
		for(int index = 0; index < list1.size(); index++) {
			System.out.println(list1.get(index)) ;
		}
		
		//	similarly, for user defined list.
		for(int index = 0; index < listOfSchool.size(); index++) {
			System.out.println(listOfSchool.get(index).srNo) ;
		}
		
		//	and...
		for(Integer item : list1) {
			System.out.println(item);
		}
		
		//	similarly, for user defined list.
		for(School school : listOfSchool) {
			System.out.println(school.srNo) ;
		}
		
		//	Method - 2
		list2.forEach(System.out :: println);
		
		//	Method - 3
		list2.forEach((value) -> {System.out.println(value); }    );
		
		listOfSchool.forEach((eachObj) -> {System.out.println(eachObj.srNo);}    );
		
		//	Method - 4
		Iterator<Integer> listItr = list1.iterator() ;
		while(listItr.hasNext()) {
			Integer value = listItr.next();
			System.out.println(value);
		}
		
		Iterator<School> schoolItr = listOfSchool.iterator() ;
		while(schoolItr.hasNext()) {
			School eachObj = schoolItr.next() ;
			System.out.println(eachObj.srNo);
		}
		
		
		
		//------------------ Sorting list --------------------
		
		Collections.sort(list2);
		//	OR
		list2.sort((n1, n2) -> {return ((Integer)n1).compareTo((Integer)n2); }	);
		
		//	similarly...
		listOfSchool.sort((obj1, obj2) -> {return ((Integer)obj1.srNo).compareTo((Integer)obj2.srNo) ;}	) ;
		
		//	to simplify the above method, we can also override the compareTo method in the class.
		listOfSchool.sort((obj1, obj2) -> {return obj1.compareTo(obj2);	}   );
		
		
		
		
		//------------------- Removing elements ----------------------
		
		while(list2.size() > 0) {
			list2.remove(0) ;
		}
		
		//	similarly...
		while(listOfSchool.size() > 0) {
			listOfSchool.remove(0) ;
		}
	}
}
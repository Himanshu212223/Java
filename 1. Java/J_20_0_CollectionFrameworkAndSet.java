
/*
 	Collection Framework :
 	___________________________________
 	
 	It is nothing, but, an object which group multiple elements into single unit, 
 	and, hence, easy to store, retrieve and modify data.
 	
 	Collection Interfaces are : Set, List, Queue, Deque, Map.
 	
 	Collection Classes are 	  :
	For List - ArrayList, LinkedList, Vector, Stack
	For Queue - PriorityQueue
	For DeQueue - Array DeQueue
	For Set - HashSet, LinkedHashSet, TreeSet
	For Map - Hash Table, HashMap, LinkedHashMap, TreeMap

 								
	Set 		: Does not contain duplicate elements.
	SortedSet 	: Stores the data in ascending order.
	List 		: Elements are stored in order or index wise.
	Queue 		: Typically follow FIFO order.
	Deque 		: Can follow both FIFO or LIFO order.
	
	
	
	1. Set :-
	________________
	
	- Set is unordered collection of unique elements.
	- Set Interface can have 3 different classes as, HashSet, LinkedHashSet, and TreeSet.
	- HashSet stores data in such a format that nobody can explain.
	- TreeSet stores data in sorted ascending order.
	- LinkedHashSet stores data in order of insertion of data.
 */


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


class Library{
	public int srNo ;
	String bookName ;
	
	public Library() { }
	
	public Library(int srNo, String bookName) {
		this.srNo = srNo ;
		this.bookName = bookName ;
	}
	
};


public class J_20_0_CollectionFrameworkAndSet {
	public static void main(String [] args) {
		
		Set<Integer> set1 = new HashSet<>() ;
		Set<Integer> set2 = new LinkedHashSet<>() ;
		Set<Integer> set3 = new TreeSet<>() ;
		
		Set<Integer> set4 = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9) ; //	This will insert immutable elements in set.
		
		//	to insert mutable elements in set, we use add method.
		
		set1.add(3) ;
		set1.add(1) ;
		set1.add(4) ;
		set1.add(2) ;
		
		set2.add(4) ;
		set2.add(1) ;
		set2.add(3) ;
		set2.add(2) ;
		
		set3.add(4) ;
		set3.add(1) ;
		set3.add(3) ;
		set3.add(2) ;
				
		//	Printing the whole set.
		
		System.out.println("HashSet is " + set1) ;
		System.out.println("LinkedHashSet is " + set2) ;
		System.out.println("Tree Set is " + set3) ;
		
		
		//	Different way to iterate the set :-
		
		//	Method - 1
		
		for(Integer value : set1) {
			System.out.println(value + " is the value of set1. ") ;
		}
		
		//	Method - 2
		
		System.out.println("Now, printing the values of set2 using for each loop. ") ;
		
		set2.forEach(System.out::println) ;
		
		//	Method - 3
		
		set3.forEach( (value) -> { System.out.println(value + " belongs to set3 ");	}	);
		
		//	Method - 4
		
		Iterator<Integer> itr1 = set4.iterator() ;
		while(itr1.hasNext()) {
			System.out.println(	itr1.next()	) ;	//	return toString
		}
		
		//------------------ Removing elements from Set -------------------------
		
		Iterator<Integer> itr2 = set1.iterator() ;
		while(itr2.hasNext()) {
			set1.remove(itr2.next()) ;
		}
		
		
		//_____________User Defined Set of objects_______________________________
		
		Set<Library> LibrarySet = new HashSet<>() ;
		
		LibrarySet.add(new Library(1, "Lets C")) ;
		LibrarySet.add(new Library(2, "Lets Java")) ;
		LibrarySet.add(new Library(3, "Lets Js")) ;
		LibrarySet.add(new Library(4, "Lets Python")) ;
			
		//----------------------iterating the above set--------------------------
		
		for(Library object : LibrarySet) {
			System.out.println(object.srNo + " - " + object.bookName) ;
		}
		
		LibrarySet.forEach(System.out :: println);	//	This will print toString
	
		LibrarySet.forEach((object) -> {System.out.println(object.srNo + " - " + object.bookName);	} );
	
		Iterator<Library> itr3 = LibrarySet.iterator() ;
		while(itr3.hasNext()) {
			Library object = itr3.next();
			System.out.println(object.srNo + " - " + object.bookName) ;
		}
		
		//---------------- Removing element from LibrarySet ---------------------
		
		Iterator<Library> itr4 = LibrarySet.iterator() ;
		while(itr4.hasNext()) {
			LibrarySet.remove(itr4.next() ) ;
		}
		
	}
}
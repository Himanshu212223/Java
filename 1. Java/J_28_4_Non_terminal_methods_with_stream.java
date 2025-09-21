/*
  		1. non-terminal methods .:
  		.filter(), .map(), .flatMap(), .distinct(), .limit()... etc.
  		
  		non-terminal methods returns a stream of objects.
  		
  		2. terminal methods .:
  		.collect(), .count(), .min(), .max(), .reduce(), .forEach(), .toArray(), ...... etc
 */



import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class J_28_4_Non_terminal_methods_with_stream {
public static void main(String [] args) {
	
	List<Integer> list1 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 7, 9, 0);
	
		//	want distinct elements .{here, distinct will return a stream of distinct elements which is then gets collected}
	List<Integer> distinctElementList = list1.stream().distinct().collect(Collectors.toList());
	distinctElementList.forEach(e -> System.out.print(e + " "));
	
		//	want to count elements.
	long count = list1.stream().count();
	System.out.println("actual Total elements in list : " + count) ;
	System.out.println("Total elements after distinct : " + list1.stream().distinct().count()  ) ;
	
		//	want only 5 elements from the list, then use limit.
	List <Integer> limitedList = list1.stream().limit(5).collect(Collectors.toList()) ;
	limitedList.forEach(System.out::print);
	
		//	want min and max values 
	Optional <Integer> min = list1.stream().min((val1, val2) -> { return val1.compareTo(val2); } );
	System.out.println(min.get()) ;
		
		//	want max and max values 
	Optional <Integer> max = list1.stream().max((val1, val2) -> { return val1.compareTo(val2); } );
	System.out.println(max.get()) ;
	
		//	want to reduce the list with sum till that element.
	Optional <Integer> reduced = list1.stream().reduce((a,b) -> {return a+b ;	});
	System.out.println("Reduced list" + reduced.get()) ;
	
		//	want to convert a List to array.
	List <String> stringList = Arrays.asList("A", "B", "C", "1", "2", "3");
	
	Object arr[] = stringList.stream().toArray();
	for(Object obj : arr) {
		System.out.print(obj) ;
	}
	
	}
}

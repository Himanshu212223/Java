
import java.util.List;
import java.util.Optional;

/*
Optional Class :-
_______________________________

	- Sometimes, when we are fetching data from another source, we are not sure 
		that whether that data will be present or there will be a null value.
	- So, its difficult to handle such case. For this reason, Optional class was 
		introduced.
	- Optional have to capability to even store the null value.
*/


public class J_19_0_OptionalClass {
	
	public static void main(String args[]) throws Exception{
		
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

		// to make an empty optional.
		Optional<Integer> opt1 = Optional.empty();

		// to make an optional which cannot have null value.
		Optional<List<Integer>> opt2 = Optional.of(list);

		// to make an optional which can have null values.
		Optional<List<Integer>> opt3 = Optional.ofNullable(list);

		// to perform operations on values stored in optional.
		opt2.ifPresent((value) -> {
			System.out.println(value);
		});

//		to store opt2 if its not null, else, store list in list2.
		List<Integer> list2 = opt2.orElse(list);

		List<Integer> list3 = opt2.orElseThrow(Exception :: new) ;
		
		System.out.println(opt1);
		System.out.println(opt2);
		System.out.println(opt1.isPresent()); 	// return true if not-null.
		System.out.println(opt2.isPresent()); 	// return true if not-null.
		System.out.println(opt2.get());			// to get the content of opt2.
		System.out.println(opt3) ;
		System.out.println(list2) ;
		System.out.println(list3) ;

		
	}
}

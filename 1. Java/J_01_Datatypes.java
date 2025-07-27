package learning;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class J_01_Datatypes {
	
	public static int a ;
	
	public static void main(String [] args) {
		
		/*
		  	PRIMITIVE DATATYPE - 
		  	---------------------------------
		  	
		  	- Primitive data types are the fundamental building blocks of data manipulation.
		  	- Primitive data types have pre-defined value as 0 or null ( it does not store garbage value)
		  		but it is only applicable to those variables which are getting used or defined in a class.
		  		
		  		If we declare a variable in our main method without initialization in our main method, 
		  			it will throw error.
		  		But, we declare a variable in our main method without initialization in a class, it will
		  			return default value either 0 or null.
		  	
		 */
		
		//	int b ;  	// this will throw error.
		
		System.out.println(a) ;		// this will return default value.
		
		// Initialization of value to Variables.
		boolean status = false;
		byte b1 = 0 ;
		char c1 = 'c';
		short s1 = 34 ;
		int i1 = 34 ;
		long l1 = 34 ;
		long l2 = 34L ;
		long l3 = 34l ;
		float f1 = 34 ;
		//	float f2 = 34.0 ;   - this will give error
		float f3 = 34.0F ; 
		float f4 = 34.0f ; 
		double d1 = 34 ;
		double d2 = 34.0 ;
		double d3 = 34.0D ;
		double d4 = 34.0d ;
		double d5 = 34d ;
		
		
		
		/*
		  	Derived or Non Premitive Datatypes or Reference Type
		  	---------------------------------------------------------
		  	- Non-primitive data types are called reference types because they refer to objects.
		  	- Non-primitive data types are derived from Primitive datatypes. 
		 */
		
		Boolean bool1 = false ;
		Byte byte1 = 34 ;
		Character char1 = 'a';
		Short short1 = 34 ;
		Integer int1 = 34;
		Long long1 = 34L ;
		Long long2 = 34l ;
		//	Float float1 = 34.0 ;	- this will give error
		Float float2 = 34f;
		Float float3 = 34F;
		Double double1 = 34.0 ;
		Double double2 = 34d ;
		Double double3 = 34D ;
		Double double4 = 34.0D ;
		String str = new String();
		
		
		// Arrays
		
		int arr1[] ;
//		int arr2[5] ;  						- this will give error
//		int arr3[5] = {1, 2, 3, 4, 5} ;		- this will give error 	
		int arr4[] = {1, 2, 3, 4, 5, 6};
		int arr5[] = new int[5];		// array of size 5 
		int arr6[] = null ;
		
		int[] arr7 ;
//		int [3] arr6 ;						- this will give error
//		int[3] arr7 = {1, 2, 3} ; 			- this will give error
		int[] arr8 = {1,2,3,4,6,4};
		int[] arr9 = new int[5];
		int[] arr10 = null ;
//		int[] arr11 = new Integer[5];  		- this will give error
		
		//	Arrays.equals(array1, array2);
		boolean arrayEqueals = Arrays.equals(arr4, arr8);  	// this will compare the values
		System.out.println("Arrays.equals = " + arrayEqueals);
		System.out.println("Arrays.compare = " + Arrays.compare(arr4, arr8));
		
		boolean arrayEqueals2 = arr4.equals(arr8);			// this will compare it as an object (i.e., object's string value)
		System.out.println(arrayEqueals2);
		
		//	Array.getLength(array);
		System.out.println(Array.getLength(arr8));
		System.out.println(arr4[3]);
		
		//	Arrays.sort(array);
		Arrays.sort(arr8);
		
		//	Arrays.binarySearch(array, value);		- gives position of value
		//	Pre-requisite of Binary Search is the items should be sorted in either ascending or descending order.
		System.out.println(Arrays.binarySearch(arr8, 4));
		
		
		
		/*
		  var data types-
		  --------------------
		  - var data types converts itself according to initialized value.
		 */
		
		var numb1 = 34 ;
		var strs = "slkfjas"; 
		var flt = 34.35 ;
		
		var date = LocalDate.now();
		System.out.println(date);
		
		
	}
}


/*
	Conclusion :
	--------------------
 	1. We cannot defined float f = 3.0 as it will give error, but same will work for double i.e., double d = 3.0 ;
 	2. We cannot mention the size of array while declaring it i.e., int[5] arr OR int arr[5] will give error.
 */

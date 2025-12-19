
import java.util.Scanner;
import java.util.regex.Pattern;

public class J_03_2_RegexExpression {
	
	public static Scanner scan = new Scanner(System.in) ;
	
	public static void main(String [] args) {
		
//		[] means statements should matches the same value defined in [].
			String regex1 = "[abc]" ;
			String statement1 = "cdf" ;   
			String statement2 = "aa" ;
			String statement3 = "a" ;
			System.out.println("1 - " + statement1.matches(regex1)) ;
			System.out.println("2 - " + statement2.matches(regex1)) ;
			System.out.println("3 - " + statement3.matches(regex1)) ;
			
			//	[^] means value should not be same as defined in []
			String regex2 = "[^abc]" ;
			String statement4 = "a" ;
			String statement5 = "g" ;
			String statement6 = "8" ;
			System.out.println("4 - " + statement4.matches(regex2));
			System.out.println("5 - " + statement5.matches(regex2));
			System.out.println("6 - " + statement6.matches(regex2));
			
			//	. means anything can fit in place of .
			String regex3 = "c.t" ;
			String statement7 = "ct" ;
			String statement8 = "cut" ;
			String statement9 = "cat" ;
			System.out.println("7 - " + statement7.matches(regex3)) ;
			System.out.println("8 - " + statement8.matches(regex3)) ;
			System.out.println("9 - " + statement9.matches(regex3)) ;
			
			//	| means matches with either cut | Cut.
			String regex4 = "cut|Cut" ;
			String statement10 = "cut" ;
			String statement11 = "put" ;
			String statement12 = "Cut" ;
			System.out.println("10 - " + statement10.matches(regex4));
			System.out.println("11 - " + statement11.matches(regex4));
			System.out.println("12 - " + statement12.matches(regex4));
			
			String regex5 = "(C|P)utting" ;
			String statement13 = "Cutting" ;
			String statement14 = "Putting" ;
			System.out.println("13 - " + statement13.matches(regex5));
			System.out.println("14 - " + statement14.matches(regex5));
			
			String regex6 = "[C|P]utting" ;
			String statement15 = "Cutting" ;
			String statement16 = "Putting" ;
			System.out.println("15 - " + statement15.matches(regex6));
			System.out.println("16 - " + statement16.matches(regex6));
			
			//	? is used to check whether the left character would appear 0 or 1 time.
			String regex7 = "cut?" ;
			String statement17 = "cu" ;
			String statement18 = "cut" ;
			String statement19 = "cutt" ;
			System.out.println("17 - " + statement17.matches(regex7));
			System.out.println("18 - " + statement18.matches(regex7));
			System.out.println("19 - " + statement19.matches(regex7));
			
			//	* is used to make the left character appear 0 to infinite times.
			String regex8 = "cut*" ;
			String statement20 = "cu" ;
			String statement21 = "cut" ;
			String statement22 = "cutt" ;
			String statement23 = "cutting" ;
			System.out.println("20 - " + statement20.matches(regex8));
			System.out.println("21 - " + statement21.matches(regex8));
			System.out.println("22 - " + statement22.matches(regex8));
			System.out.println("23 - " + statement23.matches(regex8));
			
			//	+ is used to make the left character appear 1 or more time.
			String regex9 = "cut+" ;
			String statement24 = "cu" ;
			String statement25 = "cut" ;
			String statement26 = "cutt" ;
			String statement27 = "cutting" ;
			System.out.println("24 - " + statement24.matches(regex9));
			System.out.println("25 - " + statement25.matches(regex9));
			System.out.println("26 - " + statement26.matches(regex9));
			System.out.println("27 - " + statement27.matches(regex9));
			
			//	{m}	is used to make the left character appear exactly m times.
			String regex10 = "10{5}1" ;
			String statement28 = "1000001" ;
			System.out.println("28 - " + statement28.matches(regex10));
			
			//	{m,}	is used to make the left character appear exactly m times or more.
			String regex11 = "10{5,}1" ;
			String statement29 = "1000001" ;
			String statement30 = "10000001" ;
			System.out.println("29 - " + statement29.matches(regex11));
			System.out.println("30 - " + statement30.matches(regex11));
			
			//	{m,n}	is used to make the left character appear min m and max of n times.
			String regex12 = "10{3,5}1" ;
			String statement31 = "10001" ;
			String statement32 = "1000001" ;
			System.out.println("31 - " + statement31.matches(regex12));
			System.out.println("32 - " + statement32.matches(regex12));
			
			
			//	Practice : Akshat J
			
			String regex13 = "[A-Z]{1}[a-z]* [A-Z]{1}[a-z]*" ;
			String statement33 = "User Name" ;
			System.out.println(statement33 + " is " + statement33.matches(regex13)) ;
			
			String regex14ForEmail = "[([a-z]*)([A-Z]*)]+[@]([a-z]{1,}[A-Z]*)[.]([a-z]{1,}[A-Z]*)" ;
			String statement34 = "Acb@gmail.com" ;
			System.out.println(statement34 + " is " + statement34.matches(regex14ForEmail));
			
			String regex15ForUniquePassword = "([!]*[@]*[#]*[$]*[/]*){1,}" ;
			String statement35 = "!!#@" ;
			System.out.println(statement35 + " is " + statement35.matches(regex15ForUniquePassword));
			
		
			String regex14 = "[\\w]+" ;
			String statement36 = "!@#$" ;
			System.out.println(statement36 + " is " + statement36.matches(regex14));
	}
}

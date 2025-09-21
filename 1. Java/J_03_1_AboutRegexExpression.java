
/*
 	Regex (Regular Expression) :
 	______________________________________
 	
 	Regex is used to check whether the string statement given by user is similar to the 
 	statement needed to perform any operation.
 	Like, user enters the email address, so it should follow a pattern like someThing@someThing.com
 */



import java.util.Scanner;
import java.util.regex.Pattern;

public class J_03_1_AboutRegexExpression {
	
	public static Scanner scan = new Scanner(System.in) ;
	
	public static void main (String [] args) {
		
		String regexStatement = "UserName" ;
		
		System.out.println("Enter a statement : ") ;
		String userInput = scan.nextLine();
		
		System.out.println(userInput.matches(regexStatement)) ;
		
		System.out.println(Pattern.matches(regexStatement, userInput)) ;
		//	Pattern is one of the classes provided by the Regex API.
		
		String statement = "This is the statement.";
		String [] eachWord = statement.split(" ") ;
		//	This will split each word from the sentence.
		
		//Regular Expression for Email Id Validation:
		String emailIdRegex = "([A-Za-z0-9-_]+)[@]([a-z]+)[.](com|in)";
		
		//Regex having three groups being Back-Referenced
		//The three groups must repeat after the ":" symbol in the String to match the pattern.
		String repeatRegex = "([A-Za-z0-9]+) (\\d+) ([A-Z]+) [:] \\1 \\2 \\3";
		String repeatStr = "Tom123 9090 JERRY : Tom123 9090 JERRY";
		
		/*
		 	Meta Characters for Regex Statements :-
		 	[]		:	condition is defined in the bracket.
		 	[abc]	:	matches with 'a' or 'b' or 'c'
		 	[a-z]	:	matches with any between a to z
		 	.		:	matches with any character other then newline.
		 	[a.b]	: 	can be anything like acb or azb or ahb etc.
		 	[^abc]	:	anything other than 'a' , 'b' and 'c'.
		 	abc|def	:	either abc or def.
		 	()		:	Groups expressions to form sub-expressions. like Ma(tt|nn)er gives Matter or Manner.
		 	
		 	Quantifiers :-
		 	
		 	?		:	Matches the preceding element zero or one time. Like, Ba?it matches "Bait" and "Bit".
		 	*		:	Matches the preceding element zero or more times. 10*1 matches "11", "1001", etc.
		 	+		:	Matches the preceding element one or more times. 10+1 matches "101", "1001", etc.
		 	{m}		:	Matches the preceding element exactly m times. 10{4}1 matches "100001".
		 	{m,}	:	Matches the preceding element m or more times. 10{3,}1 matches "10001", "100001", "1000000001", etc.
		 	{m,n}	:	Matches the preceding element minimum m and   maximum n times. xy{2,3}z matches "xyyz" and "xyyyz".
		 	
		 */
		
		
	}
}
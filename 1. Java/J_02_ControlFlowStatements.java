package learning;

public class J_02_ControlFlowStatements {
	
	public static void main(String args[]) {
		
		int number = 1 ;
		int a = 1 ;
		int b = 2 ;
		
		//	if-else statement
		//______________________________
		
		if(number == a) {
			System.out.println("number is equals to a.");
		}
		else {
			System.out.println("number is not euqals to a.");
		}
		
		//	if - else if - else statement
		//______________________________
		
		if(number == a) {
			System.out.println("number is equals to a.");
		}
		else if(number == b) {
			System.out.println("number is equals to b.");
		}
		else {
			System.out.println("number is neither equals to a nor equals to b.");
		}
		
		//	switch statement
		//______________________________
		
		switch(number) {
		case 1 : 
			System.out.println("number is equals to a.");			
			break;
		case 2 : 
			System.out.println("number is equals to b.");
			break;
		default:
			System.out.println("number is neither equals to a nor equals to b.");
			break;
		}
		
		int [] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
		
		for(int i=0; i < numbers.length; i++) {
			System.out.print(i) ;
		}
		
		
		//	while statement
		//______________________________
		
		int i = 0; 
		while(i < numbers.length) {
			System.out.print(i) ;
			i++ ;
		}
		
		//	do-while statement
		//______________________________
			
		int j = 0; 
		do{
			System.out.print(i) ;
			j=j++ ;
		}
		while(j < numbers.length) ;
		
		
		//	Special for Loop
		//---------------------------------
		for(int element : numbers) {
			System.out.print(element);
		}
		
		
		
		
			
		
	}
}

package learning;


class Mathematics{
	public int additionPositiveNumbers(int a, int b) {
		return a + b ;
	}
	
	
	public int division(int a, int b) throws UserDefinedException{
		int result = a/b;
		return result;
		}
}



public class J_163_UseUserDefinedException2 {
	
	public static void main(String args[]) throws UserDefinedException{
		
		Mathematics math = new Mathematics();
		int a = -1 ;
		int b = 9 ;
		
		try {
			if(a < 0 || b < 0) {
				throw new Exception("Non Positive Number.");
			}
		}
		catch(Exception e) {
			System.out.println("The Exception is " + e.getMessage());
		}
		
		
		try {
			math.division(5, 0);
		}
		catch(UserDefinedException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Yaha pe aa gae");
		
	}
}

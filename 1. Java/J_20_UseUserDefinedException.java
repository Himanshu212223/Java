package learning;

public class J_162_UseUserDefinedException {
	
	public static void main(String args[]) throws UserDefinedException, InvalidString {
		int a = -1 ;
		
		try {
			if(a < 0) {
				throw new UserDefinedException("Non Positive Number is entered.");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			throw new InvalidString("This is invalid string");
		}
		
		
		
		try {
			throw new UserDefinedException("Non Positive Number is entered.");
		}
		catch(UserDefinedException e) {
			System.out.println(e);
			throw new InvalidString("This is invalid string");
		}
		catch(Exception e) {
			
		}
		
	}
	
}

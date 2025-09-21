
import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

public class J_29_5_OpenAnyFile {
	public static float sumTwoNumbers(int a, int b) {
		return a + b ;
	}
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String [] args){
	
		try {
			String path = "C:\\windows\\system32\\cmd.exe" ;
			File file = new File(path) ;
			
			if(! file.exists()) {
				throw new Exception("!!!! File doesnot exist !!!!");
			}
			
			Desktop.getDesktop().open(file);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
}

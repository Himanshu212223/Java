
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J_29_2_ReadingTextFile {
	public static void main(String[] args) throws FileNotFoundException {

		// ------------- Reading from File -----------------------------

		String address = "C:\\Users\\himanshu13140\\Desktop\\Complete Java Developer Course\\Complete Java\\1. Datatypes.txt";

		File obj = new File(address);

		Scanner reader = new Scanner(obj);

		String data = "";

		while (reader.hasNext()) {
			data += reader.nextLine();
			data += "\n";
		}

		System.out.println(data);
	}
}

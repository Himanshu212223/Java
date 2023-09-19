package com.FileHandlings;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
	public static void main(String[] args) throws IOException {
		// ------------------ Writing in Text file ------------------
		//	Remember, this will create a file if not present, and append the content file if file is present.
		
		String address = "C:\\Users\\himanshu13140\\Desktop\\Complete Java Developer Course\\Complete Java\\File Handling\\sample.txt";
		
		FileWriter writer = new FileWriter(address, true) ;
		
		String data = "This is going to be stored in file. \n" ;
		writer.write(data) ;
		
		writer.close() ;
	}
}

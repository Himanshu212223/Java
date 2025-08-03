package com.FileHandlings;

import java.io.File;
import java.io.IOException;

public class FileCreating {
	public static void main(String [] args) throws IOException {
		
		//-------------- Creating a File ----------------------------
		
		String address = "C:\\Users\\himanshu13140\\Desktop\\Complete Java Developer Course\\Complete Java\\MyFile.txt";
		
		File obj = new File(address) ;
		
		if( obj.createNewFile() ) {
			System.out.println("File Created.... ") ;
		}
		else {
			System.out.println("File already exist... ") ;
		}
		
		

	}
}

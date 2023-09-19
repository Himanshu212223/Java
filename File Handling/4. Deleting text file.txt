package com.FileHandlings;

import java.io.File;

public class DeletingFile {
	public static void main(String [] args) {
		
		//-------------------- Deleting File ---------------------
		
		String address = "C:\\Users\\himanshu13140\\Desktop\\Complete Java Developer Course\\Complete Java\\File Handling\\sampleFile.txt" ;
		
		File obj = new File(address) ;
		
		if( obj.delete() ) {
			System.out.println("file deleted. ") ;
		}
		else {
			System.out.println("File doesnot exist") ;
		}
	}
}

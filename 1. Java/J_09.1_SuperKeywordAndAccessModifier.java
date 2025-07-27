
/*
  	Super :-
  	___________________________
  	
  	- Whenever we are handling the class which is inheriting some class, then, we have to
  		first execute or can say calls the constructor of parent class using super() so that 
  		initialization of variables in the parent class can be done.
  	
  	- super() should be called at the starting of the child constructor, otherwise, gives error.
  	
  	
  	Access Modifiers :-
  	___________________________
  	
  	It help to restrict the scope of a class, constructor, variable, method, or data member. 
  	There are four types of access modifiers :- 

	1. Default – No keyword required
	2. Private
	3. Protected
	4. Public
	
	
	
					Private 		Default 		Protected		Public
				
	within class    : 	Y			Y			Y			Y
		
	within package  :		N			Y			Y			Y
	
	outside package 
	by subclass only:		N			N			Y			Y
	
	outside package :		N			N			N			Y
	
	
	
	So, if within the same Package, if one class extends or use the object of another class, then,
	excluding private members, all the members will be visible.
	
	But, in another package, if one class extends or calls the object of another class, then,
	only public members will be visible.
	
	
 */

package PracticeFiles;

class Folder1{
	public int numberOfFiles ;
	public int size ;
	
	Folder1(){}
	
	Folder1(int numberOfFiles, int size){
		this.numberOfFiles = numberOfFiles ;
		this.size = size ;
	}
} ;


class Folder2 extends Folder1{
	public String fileType ;
	public boolean application ;
	
	Folder2(){
		super() ;
	}
	
	Folder2(int numberOfFiles, int size, String fileType, boolean application){
		super(numberOfFiles, size) ;
		this.fileType = fileType ;
		this.application = application ;
	}
};


public class SuperKeyWord {
	public static void main(String [] args) {
		Folder2 folder2 = new Folder2() ;
	}
}
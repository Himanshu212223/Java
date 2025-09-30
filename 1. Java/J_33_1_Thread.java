/*
	Threads :-
	_____________
	
	- Threading is used to perform multiple actions in parallel to each other.
	- We have to just override the run method of Thread class, and calls all the method in run
		method of Thread.
	- To execute the Thread run, we have to make the object of that class which is extending the Thread, 
		and calls its start method so that it manages to run the method in parallel.
.........................................................................................................
	- In Java, if one method gets executed completely, then, the execution of other methods starts.
	- Suppose, we are making a Web-App, and our back-end takes 5 second to load and front-end takes
		3 second to load completely.
		So, that means, once we called the back-end method and then calling front-end method, it 
		will take total of 8 second to completely load the site.
	- But, for good user experience, our webApp should load in minimum time, and is only possible 
		if both back-end and front-end starts loading at the same time.
	- Thread will resolve this.
	
*/



import java.util.concurrent.TimeUnit;

class WebApp1_FrontEnd{
	public void loadFrontEnd() throws InterruptedException {
		System.out.println("Start Loading FrontEnd Web-App 01.");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Done Loading FrontEnd Web-App 01.");
	}
};

class WebApp1_BackEnd{
	public void loadBackend() throws InterruptedException {
		System.out.println("Start Loading BackendEnd Web-App 01.");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Done Loading BackendEnd Web-App 01.");
	}
};



class WebApp2_FrontEnd extends Thread{
	public void loadFrontEnd() throws InterruptedException {
		System.out.println("Start Loading FrontEnd Web-App 02.");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Done Loading FrontEnd Web-App 02.");
	}
	
	@Override
	public void run() {
		try {
			this.loadFrontEnd();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};


class WebApp2_BackEnd extends Thread{
	public void loadBackend() throws InterruptedException {
		System.out.println("Start Loading BackendEnd Web-App 02.");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Done Loading BackendEnd Web-App 02.");
	}
	
	@Override
	public void run() {
		try {
			this.loadBackend();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};




public class J_33_1_Thread {
	
	public static void main(String args[]) throws Exception{
		
//		Execution of Web-App 1 
//			WebApp1_FrontEnd web1F = new WebApp1_FrontEnd();
//			WebApp1_BackEnd web1B = new WebApp1_BackEnd();
//			web1F.loadFrontEnd();
//			web1B.loadBackend();
			
			System.out.println("\n\n");
			
//			Execution of Web-App 2
			WebApp2_FrontEnd web2F = new WebApp2_FrontEnd();
			WebApp2_BackEnd web2B = new WebApp2_BackEnd();
			web2F.start();
			web2B.start();
		
	}
}

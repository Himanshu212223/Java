# Creating a Thread

There are two ways to create a thread.

1. It can be created by extending the Thread class and overriding its run() method.

2. Another way to create a thread is to implement the Runnable interface.

## 1. By Extending Thread Class 

- Create a class that extends Thread. 
- Override the run() method, this is where you put the code that the thread should execute. 
- Then create an object of your class and call the start() method. 
- This will internally call run() in a new thread.


```
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
```





## 2. Using Runnable Interface

- Create a class that implements Runnable. 
- Override the run() method, this contains the code for the thread. 
- Then create a Thread object, pass your Runnable object to it and call start().


```
// Example of using Runnable interface in Thread


class MyTask implements Runnable {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // The code that will run inside the thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(500); // pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
    }
}


public class RunnableExample {
    public static void main(String[] args) {
        
        // Create Runnable objects
        MyTask task1 = new MyTask("Task 1");
        MyTask task2 = new MyTask("Task 2");

        // Create Thread objects and pass Runnable
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

```





## Constructors of Thread Class

| Constructor 	| Action Performed | 
|---------------|------------------| 
| Thread()		| Allocates a new Thread object. |
| Thread(Runnable target)	| Allocates a new Thread object. |
| Thread(Runnable target, String name)	| Allocates a new Thread object. |
| Thread(String name)	| Allocates a new Thread object. |
| Thread(ThreadGroup group, Runnable target)	| Allocates a new Thread object. |
| Thread(ThreadGroup group, Runnable target, String name)	| It creates a new Thread with a target runnable object, a given name and belonging to a specified thread group. |
| Thread(ThreadGroup group, Runnable target, String name, long stackSize)	| It creates a new Thread with a target runnable, a given name, a specified thread group and a defined stack size. |
| Thread(ThreadGroup group, String name)	| Allocates a new Thread object. |





## Methods of Thread Class

| Method	| Action Performed |
|-----------|------------------|
| activeCount()	| Returns estimate of active threads in current thread group & subgroups. |
| checkAccess()	| Checks if current thread has permission to modify this thread. |
| clone()	| Throws CloneNotSupportedException (Thread cannot be cloned). |
| currentThread()	| Returns reference of currently executing thread. |
| dumpStack()	| Prints stack trace of current thread to standard error. |
| enumerate(Thread[] tarray)	| Copies active threads into given array. |
| getAllStackTraces()	| Returns map of stack traces for all live threads. |
| getContextClassLoader()	| Gets context ClassLoader of this thread. |
| getDefaultUncaughtExceptionHandler()	| Returns default handler for uncaught exceptions. |
| getId()	| Returns unique identifier of thread. |
getName()	Returns thread’s name. 
| getPriority()	 |Returns thread’s priority. |
| getStackTrace()	| Returns stack trace elements of this thread. |
| getState()	| Returns state of this thread (NEW, RUNNABLE, etc.). | 
| getThreadGroup()	|Returns thread group of this thread.
| getUncaughtExceptionHandler()	| Returns handler for uncaught exceptions.| 
| holdsLock(Object obj)	| Checks if current thread holds monitor lock on given object.| 
| interrupt()	| Interrupts this thread.| 
| interrupted()	| Tests if current thread is interrupted (clears status).| 
| isAlive()	| Tests if thread is alive (started & not dead).| 
| isDaemon()	| Tests if thread is daemon.| 
| isInterrupted()	| Tests if thread is interrupted (without clearing status).| 
| join()	| Waits for this thread to die.| 
| join(long millis)	| Waits max millis for this thread to die.| 
| run()	| Executes run() method (if Runnable given).| 
| setContextClassLoader(ClassLoader cl)	| Sets context ClassLoader.| 
| setDaemon(boolean on)	| Marks thread as daemon or user.| 
| setDefaultUncaughtExceptionHandler(handler)	| Sets default handler for uncaught exceptions.| 
| setName(String name)	| Changes thread’s name.| 
| setUncaughtExceptionHandler(handler)	| Sets handler for uncaught exceptions of this thread.| 
| setPriority(int newPriority)	| Changes thread’s priority.| 
| sleep(long millis)	| Pauses current thread for given milliseconds.| 
| start()	| Starts thread (JVM calls run()).| 
| toString()	| Returns string with thread name, priority & group.| 
| yield()	| Hints scheduler to pause current thread & give chance to others.| 
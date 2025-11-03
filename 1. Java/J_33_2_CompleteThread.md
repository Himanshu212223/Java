# Complete Thread in Java


Topics - 
1. What is Thread
2. Thread Lifecycle
3. Ways to Create Thread / Creating Thread
4. How to check Thread Life Cycle on Code
5. Common Methods of Thread
6. How to give a name to your Thread
7. Concurrency Problem
8. Synchronization
9. Locks
10. Thread Communication
11. Thread Safety
12. Thread Pool - Executor Framework




## 1. What is Thread

- A thread is the smallest unit of execution in a program.

- It is a lightweight sub-process inside a process.

- A process (like a Java program) can have multiple threads running at the same time.

- For Example - When we open Chrome Browser, a application starts by the Chrome Browser and when we open multiple tabs like one is opening Gmail, while other is opening Youtube, then this process gets divided into multiple threads where each thread execute independently like both the chrome tabs work independently.

- By Default, the Main method is also a process which runs in Thread.





## 2. Thread Lifecycle

- **New :-** A Thread is in this state when it is created but not yet started. 
- **Runnable :-** After the start method is called, the Thread becomes runnable. It's ready to run and is waiting for CPU time.
- **Running :-** The Thread is in this state when it is executing.
- **Blocked / Waiting :-** The Thread is in this state when it is waiting for a resource or for another thread to perform an action.
- **Terminated :-** A Thread is in this state when it has finised execution.






## 3. Creating Thread

There are 2 ways to create the Thread - 
1. Extend Thread class.
2. Implements Runnable Interface.

### 3.1. Extend Thread Class.

Suppose we have 2 class, one is our main class which other class is World class.

`World.class`
```
public class World extends Thread {

    @Override
    public void run() {
        //  Write your code here.
        for (; ; ){
            System.out.println("This is the task executing in Thread");
        }
    }

}

```


`Main.class`
```
public class Main {

    public static void main (String [] args) {

        World world = new World () ;    // NEW State of Thread
        world.start();                  // RUNNABLE State of Thread

        for( ; ; ){
            System.out.println("This is some long task getting executed on the main class");
        }

    }
    
}
```




### 3.2. Implements Runnable Interface.

Suppose we have 2 class, one is our main class which other class is World class.

`World.class`
```
public class World implements Runnable {

    @Override
    public void run() {
        //  Write your code here.
        for (; ; ){
            System.out.println("This is the task executing in Thread");
        }
    }

}

```


`Main.class`
```
public class Main {

    public static void main (String [] args) {

        World world = new World () ;
        
        //  Now Create the Thread of World class and start it.

        Thread t1 = new Thread(world) ;
        t1.start();


        for( ; ; ){
            System.out.println("This is some long task getting executed on the main class");
        }

    }
    
}
```




> ### Where to use which one -
>
> 1. If a class already extens some other class, then we can't extend it with Thread class, hence use implements Runnable Interface there.







## 4. How to check Thread Life Cycle on Code - 

```
public class MyThread extends Thread {

    @Override
    public void run () {
        try{

            //  Lets sleep the current thread for 2 seconds
            Thread.sleep(2000);

        }
        catch(InterruptedException e){
            System.out.println(e) ;
        }
    }





    public static void main(String args []) throws InterruptedException {

        //  since the above run method is not static, we need to create the object of the class.
        MyThread t1 = new MyThread() ;

        System.out.println(t1.getState());      //  NEW State

        t1.start();

        System.out.println(t1.getState());      // RUNNABLE State

        // Now lets make the main method (as main is also a Thread) to sleep
        Thread.sleep(100);

        System.out.println(t1.getState());      // TIME Blocked State

        t1.join();

        System.out.println(t1.getState());      //  Terminated State

    }

}
```


> ### Notes -
>
> - **Thread** keyword used on any method or block represents the current Thread.
> - **getState()** method is used to get the present state of the Thread.
> - **Runnable** state is the Running state on java as there is no separate Running state.
> - **start()** method is used to trigger the **run** method of the Thread.
> - **join()** method waits for the Thread Termination.







## 5. Common methods of Thread

1. **run()** → This method is defined on the Thread class and we override this (after extending Thread or implementing the Runnable) method as we define our main code inside it. 
2. **start()** → It is used to trigger the run method of the Thread Execution.
3. **Thread.sleep(3000)** → This method is used to suspend the Thread executing for the mentioned time period.
4. **join()** → It helps to **wait for the Termination** of the Thread Executing **before proceeding further**.
5. **setPriority(Thread.MIN_PRIORITY)** → It is used to change or set the Priority of the Thread.
6. **interrupt()** → It is used to interrupt the current ongoing Thread.
7. **Thread.yield()** → It is used to hint the JVM to give the chance to other Thread for the execution.
8. **setDaemon(true)** → It is used to make the Tread as Daemon. Daemon Thread is a thread which keeps on running in the background (like some useless task) and JVM doesn't wait for its termination.







## 6. How to give a name to your Thread - 

```
public class MyThread extends Thread {

    // calling Thread constructor via super 
    public MyThread (String threadName){
        super(threadName) ;
    }




    @Override
    public void run () {
        ....... Your Code .....................
    }





    public static void main(String args []) throws InterruptedException {

        MyThread t1 = new MyThread("customThread") ;

    }

}
```





## 7. Concurrency Problems -

1. **Race Condition:** Occurs when multiple threads access shared data simultaneously, leading to inconsistent results. 

    It happens when the code is not thread-safe.

2. **Deadlock:** Happens when two or more threads are blocked forever, each waiting for the other to release a lock.

3. **Livelock:** Threads are active but unable to make progress because they keep responding to each other in an endless loop.

4. **Thread Starvation:** A thread is perpetually denied access to resources because other threads are given priority.

5. **Priority Inversion:** Occurs when a low-priority thread holds a lock needed by a high-priority thread, blocking its progress.





## 8. Synchronization

### 8.1. What is Synchronization in Java?

- In multithreading, when multiple threads access a shared resource (like a variable, method, or object) at the same time, it can cause data inconsistency.

- Synchronization is a mechanism that ensures only one thread can access a shared resource at a time.
It prevents race conditions.

- The part of code which needs to be synchronized is called critical section.

- Synchronization helps to overcome the race condition.


### Example Without Synchronization (Problem) - 

```
class Counter {
    private int count = 0;

    public void increment() {
        count++; // not thread-safe
    }

    public int getCount() {
        return count;
    }
}

public class WithoutSync {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Two threads incrementing same counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expected = 2000, but result may vary (e.g., 1935, 1987, etc.)
        System.out.println("Final Count (Without Sync): " + counter.getCount());
    }
}

```

Output is inconsistent because both threads modify count at the same time.


### Example With Synchronization (Solution)

```
class Counter {
    private int count = 0;

    // synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class WithSync {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Always consistent = 2000
        System.out.println("Final Count (With Sync): " + counter.getCount());
    }
}

```


Now the result will always be 2000, because synchronized ensures only one thread executes increment() at a time.



> ### Note - 
> 
> - We can either make a method a Synchronized method by using **synchronized** keyword.
> - Or we can declare a block of code like below - 
> ```
> // synchronized block inside the method
>   public void increment() {
>        synchronized(this){
>            count ++ ;
>        }
>    }
> ```



> ### Disadvantages of Synchronization - 
> 
> 1. There is no fairness (means which Thread request needs to execute first).
> 2. Blocking / waiting the other Thread when 1 Thread is executing.
> 3. Read / Write Locking



## 9. Locks

### What are Locks in Java Threads?

- In multithreading, multiple threads may want to access a shared resource (like a variable, object, or file).

- To prevent race conditions and data inconsistency, we need synchronization.

- In Java, we usually use synchronized keyword. But for more advanced control, Java provides Locks in the java.util.concurrent.locks package.

- A Lock is an interface that provides:
    - Explicit lock() and unlock() methods.
    - More flexibility than synchronized.
    - Ability to check if a lock is available (tryLock()).
    - Ability to make lock acquisition interruptible.

Locks are of 2 types - 
1. Implicit Lock
2. Explicit Lock

#### 9.1. Implicit Lock

- When we use the **synchronized** keywork at method or block level, we are using the implicit lock where JVM locks the executing of the method or task for 1 Thread at a time.


#### 9.2. Explicit Lock

-  When we wants to define when to Lock and when to unclock the method execution by 1 Thread at a time, we use Explicit Locks.



### 9.2. Explicit Lock

Example: Using ReentrantLock

```
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    
    //private final ReentrantLock lock = new ReentrantLock(true);  --> if we pass true here, that means the Thread will come 1st will get the access.

    private final ReentrantLock lock = new ReentrantLock(true);

    public void increment(String threadName) {
        lock.lock();  // acquire lock
        try {
            count++;
            System.out.println(threadName + " incremented count to: " + count);
        }
        catch(Exception e){
            Thread.currentThread().interrupt();     //  Helps to understand there was some interruption here in the Thread.
        }
         finally {
            lock.unlock(); // release lock (always in finally)
        }


        if(Thread.currentThread().isInterrupted()){
            ..... log the message there there was some interruption .................
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        
        SharedCounter counter = new SharedCounter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment(Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

```




> ### Note - 
>
> - There could be situation in a Thread when one method lock A is waiting for another method lock B to finish while the method block B is waiting for method lock A to finish.
> - This situation is called **Dead Lock**.
> - **ReentrantLock** helps to avoid this situations in Java.
> - **ReentrantReadWriteLock** is used to allow all the Thread which are performing read operation when no other Thread is performing Write operations.









### 9.3. Common methods of Lock

1. **lock.tryLock()** → It tries to acquires the lock if it is free else return false. 
2. **lock.tryLock(5000, TineUnit.MILISECONDS)** → It tries to wait for 5 seconds toacquires the lock if it is free else return false. 
3. **lock.lock()** → It also tries to acquire the lock.
3. **lock.unlock()** → It is used to unclock the method once 1 thread is done using it.





### 9.4. How to use Read-Write Lock

```
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    
    //private final ReentrantLock lock = new ReentrantLock(true);  --> if we pass true here, that means the Thread will come 1st will get the access.

    private final ReentrantLock lock = new ReentrantReadWriteLock(true);

    //  Define Read and Write locks

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    //  Below method is writing, hence will use the write lock

    public void increment(String threadName) {
        writeLock.lock();  // acquire lock
        try {
            count++;
            System.out.println(threadName + " incremented count to: " + count);
        }
        catch(Exception e){
            Thread.currentThread().interrupt();     //  Helps to understand there was some interruption here in the Thread.
        }
         finally {
            writeLock.unlock(); // release lock (always in finally)
        }


        if(Thread.currentThread().isInterrupted()){
            ..... log the message there there was some interruption .................
        }
    }



    //  Below method is for reading, hence will use the read lock.

    public int getCount(){

        readLock.lock(); 

        try{
            return count ;
        }
        finally {
            readLock.unlock();
        }
    }

}

public class LockExample {
    public static void main(String[] args) {
        
        SharedCounter counter = new SharedCounter();

        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                counter.getCount();
            }
        };

        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment(Thread.currentThread().getName());
            }
        };


        Thread t1 = new Thread(readTask, "Thread-1");
        Thread t2 = new Thread(writeTask, "Thread-2");

        t1.start();
        t2.start();
    }
}

```









## 10. Thread Communication.

- Whenever multiple threads are running and are synchronized or using explicit locking, so 1 thread acquire the lock at a time while other threads keep on checking if the lock is unlocked.
- This process of checking again and again waste a lot of CPU usage and affect the performance.
- To resolve this issue, we try to make the Thread communicate with each other so that we can ask other threads to wait and once the execution is done, we can notify other threads to acquire lock.
- Methods used for Thread communication are - `wait()`, `notify()`, and `notifyAll()`.




## 11. Thread Safety

- When a Thread guarentee that there will be no inconsistency of data when multiple Threads are trying to access it.

- We tries to achieve Thread Safety using Synchronized (which is implicit locking) or Explicit Locking, etc.






## 12. Thread Pool

- A Thread Pool is a collection of pre-created, reusable threads that are kept ready to perform tasks.

- Instead of creating a new thread every time you need to run something (which is costly in terms of memory and CPU), a thread pool maintains a fixed number of threads.

- When a task is submitted:

    - If a thread is free, it immediately picks up the task and runs it.
    - If all threads are busy, the task waits in a queue until a thread becomes available.
    - After finishing a task, the thread does not die. It goes back to the pool and waits for the next task.


## 12.1. Benefits of Thread Pool -

**Better Performance:** Threads are reused instead of being created and destroyed repeatedly.

**Faster Response Time:** Tasks don’t need to wait for a new thread to be created.

**Reusability:** Threads remain alive after finishing tasks and are reused for future tasks.

**Resource Management:** Limits the number of concurrent threads, preventing OutOfMemoryError or CPU overload.




## 12.2. Executors Framework - Thread Pooling

- Interfaces of Executors Framework are - `Executor`, `ExecutorService` and `ScheduledExecutorService`.


So now we don't have to create multiple Threads as per our requirement, instead the Executor will create the Threads.

```
public class Main {

    public static void main (String [] args){
        
        //  Create a Thread Pool of 5 threads.

        ExecutorService executorService = Executors.newFixedThreadPool(5) ;

        for(int i = 1; i <= 5 ; i++ ){

            int finalI = i ;
            
            executorService.submit( () -> {
                long result = factorial (finalI) ;
                System.out.println(result) ;
            });
        }

        executorService.shutdown() ;
        
    }
    
}
```




### 12.3. Common methods of Executors

1. **executorService.submit()** → It is used to assign the Task to any of Thread of Thread pool and triggers the run method.
2. **executorService.shutdown()** → It is used to shutdown all the Threads of the Thread Pool once the task has been completed.
3. **executorService.awaitTermination(5, TimeUnit.SECONDS)** → It is used to wait for 5 seconds to finish the task and shutdown the execution and if it takes more than 5 seconds then it will return false.
4. **executorService.isShutdown()** → It is used to check if Executor Service has been shut down.
4. **executorService.isTerminated()** → It returns true if all tasks are completed after shutdown.





### 12.4. Runnable vs Callable in Executor Service

#### Runnable

- **Package:** java.lang
- **Method:** public void run()
- **Return Type:** void (does not return anything)
- **Checked Exceptions:** Cannot throw checked exceptions
- **Usage:** Used when you just want to execute a task in a thread, but don’t need a result back.

Example:

```
Runnable task = () -> {
    System.out.println("Runnable task executed!");
};
new Thread(task).start();

```

#### Callable

- **Package:** java.util.concurrent
- **Method:** public V call() throws Exception
- **Return Type:** Generic type V (can return a value)
- **Checked Exceptions:** Can throw checked exceptions
- **Usage:** Used when you want the task to return a result or throw exceptions. Usually executed with ExecutorService and returns a Future.

Example:
```
import java.util.concurrent.*;

Callable<Integer> task = () -> {
    return 10 * 2;
};

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(task);

System.out.println("Result: " + future.get()); // Output: 20
executor.shutdown();

```


| Feature     | Runnable                        | Callable                      |
| ----------- | ------------------------------- | ----------------------------- |
| Return type | void                            | Generic (V)                   |
| Method      | run()                           | call()                        |
| Exceptions  | Cannot throw checked exceptions | Can throw checked exceptions  |
| Package     | java.lang                       | java.util.concurrent          |
| Used with   | Thread or anywhere              | ExecutorService (with Future) |




### 12.5. Scheduled Executor Service

- If we wants to schedule the Executor to execute at certain time, we can use this Executor.

```
public class Main {

    public static void main (String args[] ) {

        //  Create a ScheduledExecutor Thread Pool of size 1.
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //  Create a schedule which will execute after 5 seconds.
        scheduledExecutorService.schedule(() -> {
            .... your code
        }, 5, TimeUnit.SECONDS);
        

        scheduledExecutorService.shutdown();
    }
    
}
```



### 12.6. Common methods of Scheduled Executors

1. **scheduledExecutorService.schedule(callback, delayTime, TimeUnit)** → It is used to execute the task after certain delay time.
2. **scheduledExecutorService.scheduleAtFixedRate(callback, initialDelay, period, TimeUnit)** → It is used to execute the task after certain delay time and then re-execute it after certain period of time.
3. **scheduledExecutorService.scheduleAtFixedDelay(callback, initialDelay, delay, TimeUnit)** → It is used to execute the task after certain delay time and then re-execute the other task after certain delay of pervious execution.











## 13. Future in Java

- In Java, a Future represents the result of an asynchronous computation. 
- It acts like a placeholder for a value that will be available at some point in the future when a task completes.
- It was introduced in Java 5 in the java.util.concurrent package.



### 13.1. Key Points about Future

- Represents a pending result of an asynchronous task.
- Returned when you submit a task to an ExecutorService.
- Provides methods to check if the task is done, wait for the result, or cancel the task.
- Works with Callable<V> (because Runnable does not return results).


### 13.2. Important Methods in Future

- **get()** → Waits if necessary for the computation to complete and then returns the result.
- **get(long timeout, TimeUnit unit)** → Waits at most the given time.
- **isDone()** → Returns true if the task is completed.
- **cancel(boolean mayInterruptIfRunning)** → Attempts to cancel execution.
- **isCancelled()** → Checks if the task was cancelled.


### 13.3. Example: Using Future with ExecutorService

```
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a Callable task that returns a result
        
        Future<Integer> future = executor.submit(() -> {
            
            System.out.println("Task is running...");
            Thread.sleep(2000); // simulate delay
            return 42;

        });

        try {
            // Check if task is done
            System.out.println("Is task done? " + future.isDone());

            // Get the result (waits if not ready)
            Integer result = future.get();

            System.out.println("Result: " + result);

            // Check again
            System.out.println("Is task done? " + future.isDone());
        } 
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

```


Output - 
```
Is task done? false
Task is running...
Result: 42
Is task done? true

```



### 13.4. Limitations of Future

- No way to manually complete a Future.
- Cannot chain multiple asynchronous tasks (no callbacks).
- Hard to compose multiple futures together.
- That’s why CompletableFuture (introduced in Java 8) was created — it extends Future and adds powerful features like callbacks, chaining, and combining multiple async tasks.









## 14. CompletableFuture

- In Java, a CompletableFuture is a class introduced in Java 8 (in the java.util.concurrent package) that represents a Future which can be explicitly completed and used to write asynchronous, non-blocking code more easily.

### Why CompletableFuture (Problem with Future)

With normal Future:

- You submit a task → get a Future.
- To get result → call future.get(), which blocks until the result is ready.

With CompletableFuture:

- You can register callbacks that run automatically when the result is available.
- No need to block manually.




### Key Points about CompletableFuture

- Implements Future and CompletionStage → can be used as both.
- Unlike Future, it does not block unnecessarily; you can attach callbacks that run automatically when the computation is done.
- Supports chaining of tasks (thenApply, thenAccept, thenRun).
- Supports combining multiple async tasks (thenCombine, allOf, anyOf).
- Makes it easier to handle async workflows compared to plain Thread or ExecutorService.

### Example 1: Simple Async Task

```
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Background task
            return "Hello from background!";
        });

        // Attach callback
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        Thread.sleep(1000); // Just to let async task finish
    }
}

```

Output - 
```
Result: Hello from background!
```


### Example 2: Chaining Tasks

```
public class CompletableFutureChain {
    public static void main(String[] args) throws Exception {
        CompletableFuture.supplyAsync(() -> "Java")
            .thenApply(str -> str + " Future")
            .thenApply(String::toUpperCase)
            .thenAccept(System.out::println);

        Thread.sleep(500); // wait for async chain
    }
}
```

Output - 
```
JAVA FUTURE
```


### Example 3: Combining Two Futures

```
public class CompletableFutureCombine {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combined = future1.thenCombine(future2, (a, b) -> a + " " + b);

        System.out.println(combined.get()); // Blocks only here
    }
}
```

Output - 
```
Hello World
```


### Example 4: Waiting for Multiple Futures

```
public class CompletableFutureAllOf {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Task1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Task2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Task3");

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);

        all.thenRun(() -> System.out.println("All tasks completed"));

        all.join(); // wait for all
    }
}
```

Output - 
```
All tasks completed
```

| Feature            | `Future`                     | `CompletableFuture`                      |
| ------------------ | ---------------------------- | ---------------------------------------- |
| Completion         | Task completes automatically | Can be completed manually too            |
| Non-blocking       | ❌ (must call `get()`)        | ✅ Supports callbacks                     |
| Task chaining      | ❌                            | ✅ `thenApply`, `thenAccept`, etc.        |
| Combining tasks    | ❌                            | ✅ `thenCombine`, `allOf`, `anyOf`        |
| Exception handling | Limited                      | Rich APIs like `exceptionally`, `handle` |

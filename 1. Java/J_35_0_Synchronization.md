# Synchronization

## What is Synchronization in Java?

- In multithreading, when multiple threads access a shared resource (like a variable, method, or object) at the same time, it can cause data inconsistency.

- Synchronization is a mechanism that ensures only one thread can access a shared resource at a time.
It prevents race conditions.


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


## Key Points:

1. synchronized can be applied to:
    - Methods
    - Code blocks (using synchronized(this) or synchronized(obj))

2. Synchronization helps avoid race conditions, but it can reduce performance because threads wait for locks.



## Types of Synchronization

There are two type of synchronizations in Java which are listed below:

1. Process Synchronization
2. Thread Synchronization




### 1. Process Synchronization in Java

- Process synchronization ensures that only one thread/process can access the shared resource at a time.

- **Synchronized method/block –** allows only one thread to execute at a time.

#### Example: Without Synchronization (Problem Case)

```
class SharedResource {
    int count = 0;

    public void increment() {
        // Not synchronized
        count++;
    }
}

class MyThread extends Thread {
    SharedResource resource;

    MyThread(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.increment();
        }
    }
}

public class WithoutSyncExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread t1 = new MyThread(resource);
        Thread t2 = new MyThread(resource);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + resource.count);
    }
}

```


Expected Output: 2000

Actual Output (Random): e.g. 1784, 1920, 2000…

This happens because both threads update count at the same time without synchronization.




#### Example: With Synchronization (Fixed)

```
class SharedResource {
    int count = 0;

    // synchronized method
    public synchronized void increment() {
        count++;
    }
}

class MyThread extends Thread {
    SharedResource resource;

    MyThread(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.increment();
        }
    }
}

public class WithSyncExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread t1 = new MyThread(resource);
        Thread t2 = new MyThread(resource);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + resource.count);
    }
}

```

Output (Always Correct): 2000

Now, the synchronized keyword ensures only one thread at a time executes increment().










### 2. Thread Synchronization in Java

When multiple threads access a shared resource (like a variable, file, or database) at the same time, their execution must be synchronized to avoid race conditions and inconsistent results.

In Java, we do this using:

- synchronized method
- synchronized block
- Lock (ReentrantLock)


#### Example 1: Using synchronized Method

```
class SharedPrinter {
    // synchronized method ensures only one thread can access it at a time
    public synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    SharedPrinter printer;
    String threadName;

    MyThread(SharedPrinter printer, String threadName) {
        this.printer = printer;
        this.threadName = threadName;
    }

    public void run() {
        printer.printNumbers(threadName);
    }
}

public class SyncMethodExample {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        // Both threads share the same printer object
        MyThread t1 = new MyThread(printer, "Thread-1");
        MyThread t2 = new MyThread(printer, "Thread-2");

        t1.start();
        t2.start();
    }
}

```


#### Example 2: Using synchronized Block

Instead of locking the whole method, we can synchronize only the critical section:

```
class SharedPrinter {
    public void printNumbers(String threadName) {
        synchronized (this) { // synchronized block
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " prints: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class SyncBlockExample {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Thread t1 = new Thread(() -> printer.printNumbers("Thread-1"));
        Thread t2 = new Thread(() -> printer.printNumbers("Thread-2"));

        t1.start();
        t2.start();
    }
}

```




## Difference between Process Synchronization and Thread Synchronization

| Feature            | Process Synchronization                              | Thread Synchronization                     |
| ------------------ | ---------------------------------------------------- | ------------------------------------------ |
|**Definition**|Ensures that two or more independent processes (running separately, possibly on different memory spaces) access shared resources in a coordinated way.|Ensures that two or more threads (within the same process, sharing memory) access shared resources in a safe and consistent way.|
| **Scope**          | Between processes (separate memory spaces)           | Between threads (within same process)      |
| **Memory Sharing** | No (uses IPC like pipes, semaphores, sockets)        | Yes (all threads share process memory)     |
| **Mechanisms**     | Semaphores, monitors, shared memory, message passing | `synchronized`, Locks, wait/notify, Atomic |
| **Speed**          | Slower (heavyweight context switch)                  | Faster (lightweight context switch)        |
| **Failure Impact** | One process crash → others survive                   | One thread crash → may kill whole process  |
| **Example**        | Two processes writing to the same file               | Two threads updating the same variable     |

# Atomic Variables

- An Atomic Variable (in Java, provided under the java.util.concurrent.atomic package) is a type of variable that allows you to perform thread-safe, lock-free operations on single variables.

- Instead of using synchronization (synchronized blocks or explicit locks) to protect access to shared variables, atomic variables use low-level atomic CPU instructions (like Compare-And-Swap, CAS) to ensure operations are completed safely in concurrent environments.


### Key Points:

- Belong to the java.util.concurrent.atomic package.
- Provide methods to perform atomic operations such as increment, decrement, update, compare-and-set.
- They are faster than using locks because they avoid context switching and blocking.
- Examples include:
    - AtomicInteger
    - AtomicLong
    - AtomicBoolean
    - AtomicReference


### Example with AtomicInteger:
```
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        // Atomically increment by 1
        counter.incrementAndGet();

        // Atomically add 5
        counter.addAndGet(5);

        // Compare and set (only updates if current value == expected)
        boolean updated = counter.compareAndSet(6, 10);

        System.out.println("Counter value: " + counter.get()); // 10 if updated
        System.out.println("Was updated: " + updated); // true if successful
    }
}

```

## Why Use Atomic Variables?

- In multithreaded applications, multiple threads may try to modify the same variable at once.
- Using normal variables may cause race conditions.
- Using synchronized ensures safety but adds overhead.
- Atomic variables provide safety + better performance (non-blocking, lock-free).



## Problem Statement

Suppose multiple threads increment a shared counter.
If we don’t handle it properly → race condition (wrong result).


### Using synchronized - 
```
class Counter {
    private int count = 0;

    // synchronized ensures only one thread at a time modifies count
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + counter.getCount()); // 2000
    }
}

```

#### Outcome - 
- Thread-safe.
- But synchronized is blocking → only one thread can access increment() at a time, so performance may drop with many threads.




### Using AtomicInteger - 

```
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // atomic operation
    }

    public int getCount() {
        return count.get();
    }
}

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + counter.getCount()); // 2000
    }
}
```


#### Outcome - 

- Also thread-safe.
- Faster because it uses CPU-level atomic instructions (CAS) instead of blocking.
- Works only for simple operations (increment, update, compare-and-set).


| Feature             | `synchronized` / Locks                 | Atomic Variables             |
| ------------------- | -------------------------------------- | ---------------------------- |
| **Thread safety**   | ✅ Yes                                  | ✅ Yes                        |
| **Blocking**        | ❌ Non-blocking                         | ✅ Blocking                   |
| **Performance**     | Slower (context switching, blocking)   | Faster (CAS, lock-free)      |
| **Complex logic**   | ✅ Can handle complex critical sections | ❌ Only simple atomic updates |
| **Code complexity** | Easy but verbose                       | Simple for counters/flags    |


### When to use what?

- Use Atomic Variables → when you just need counters, flags, or simple updates.
- Use synchronized/Locks → when you need to protect multiple related operations or complex critical sections.
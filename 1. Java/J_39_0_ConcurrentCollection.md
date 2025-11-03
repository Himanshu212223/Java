# Concurrent Collections

## What are Concurrent Collections?

- In Java, Concurrent Collections are thread-safe collection classes provided in the java.util.concurrent package.
- They are designed to be safely used by multiple threads without requiring external synchronization (synchronized blocks or locks).

- Unlike normal collections (ArrayList, HashMap, etc.), which are not thread-safe, concurrent collections internally use lock-free algorithms (like CAS) or fine-grained locking to allow better concurrency and performance.


## Why use them?

- Normal collections (like ArrayList, HashMap) can cause race conditions in multithreaded programs.

- Collections.synchronizedList() and similar wrappers exist, but they use one big lock → performance bottleneck.

- Concurrent collections solve this with better concurrency (non-blocking reads, segmented locks for writes).



## Major Concurrent Collections

### 1. ConcurrentHashMap

- Thread-safe version of HashMap.
- Allows concurrent reads and concurrent writes in different buckets.
- Uses segmented locking (or CAS in modern JDKs).


```
import java.util.concurrent.*;

public class CHMExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        map.computeIfAbsent("C", k -> 3); // thread-safe update
        System.out.println(map);
    }
}
```



### 2. CopyOnWriteArrayList

- Thread-safe version of ArrayList.
- On every write (add/remove) → creates a new copy of the array.
- Best for read-heavy, write-rare scenarios.

```
import java.util.concurrent.*;
import java.util.*;

public class COWListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");

        for (String s : list) {  // Safe even if list is modified during iteration
            list.add("C");
        }

        System.out.println(list);
    }
}
```



### 3. BlockingQueue (interface)

- Used in producer-consumer problems.
- Thread-safe queues where put() waits if full, and take() waits if empty.

- Implementations:

    - ArrayBlockingQueue
    - LinkedBlockingQueue
    - PriorityBlockingQueue
    - DelayQueue

```
import java.util.concurrent.*;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);

        // queue.put(3); // will wait because queue is full

        System.out.println(queue.take()); // removes 1
        System.out.println(queue.take()); // removes 2
    }
}
```



### 4. ConcurrentLinkedQueue

- Lock-free, non-blocking queue using CAS (compare and swap/set).
- Best for high-performance concurrent applications.

```
import java.util.concurrent.*;

public class CLQExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("A");
        queue.add("B");

        System.out.println(queue.poll()); // removes A
        System.out.println(queue.peek()); // reads B
    }
}
```




## Summary Table
| Collection                | Thread-Safe Alternative To | Use Case                |
| ------------------------- | -------------------------- | ----------------------- |
| **ConcurrentHashMap**     | HashMap                    | High concurrency map    |
| **CopyOnWriteArrayList**  | ArrayList                  | Read-heavy, write-rare  |
| **CopyOnWriteArraySet**   | HashSet                    | Read-heavy, write-rare  |
| **BlockingQueue**         | Queue                      | Producer-consumer       |
| **ConcurrentLinkedQueue** | Queue (lock-free)          | Fast non-blocking queue |

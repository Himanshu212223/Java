# Future in Java

- In Java, a Future represents the result of an asynchronous computation. 
- It acts like a placeholder for a value that will be available at some point in the future when a task completes.
- It was introduced in Java 5 in the java.util.concurrent package.



## 1. Key Points about Future

- Represents a pending result of an asynchronous task.
- Returned when you submit a task to an ExecutorService.
- Provides methods to check if the task is done, wait for the result, or cancel the task.
- Works with Callable<V> (because Runnable does not return results).


## 2. Important Methods in Future

- **get()** → Waits if necessary for the computation to complete and then returns the result.
- **get(long timeout, TimeUnit unit)** → Waits at most the given time.
- **isDone()** → Returns true if the task is completed.
- **cancel(boolean mayInterruptIfRunning)** → Attempts to cancel execution.
- **isCancelled()** → Checks if the task was cancelled.


## 3. Example: Using Future with ExecutorService

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



## 4. Limitations of Future

- No way to manually complete a Future.
- Cannot chain multiple asynchronous tasks (no callbacks).
- Hard to compose multiple futures together.
- That’s why CompletableFuture (introduced in Java 8) was created — it extends Future and adds powerful features like callbacks, chaining, and combining multiple async tasks.









# CompletableFuture

- In Java, a CompletableFuture is a class introduced in Java 8 (in the java.util.concurrent package) that represents a Future which can be explicitly completed and used to write asynchronous, non-blocking code more easily.

## Why CompletableFuture (Problem with Future)

With normal Future:

- You submit a task → get a Future.
- To get result → call future.get(), which blocks until the result is ready.

With CompletableFuture:

- You can register callbacks that run automatically when the result is available.
- No need to block manually.




## Key Points about CompletableFuture

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
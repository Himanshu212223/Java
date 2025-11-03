# Concurrency Problem

- Concurrency problems in Java arise when multiple threads access and modify shared data simultaneously, leading to unpredictable and incorrect program behavior.




## Concurrency Problems -

1. **Race Condition:** Occurs when multiple threads access shared data simultaneously, leading to inconsistent results. 

    It happens when the code is not thread-safe.

2. **Deadlock:** Happens when two or more threads are blocked forever, each waiting for the other to release a lock.

3. **Livelock:** Threads are active but unable to make progress because they keep responding to each other in an endless loop.

4. **Thread Starvation:** A thread is perpetually denied access to resources because other threads are given priority.

5. **Priority Inversion:** Occurs when a low-priority thread holds a lock needed by a high-priority thread, blocking its progress.
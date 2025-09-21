# Thread in Java -
 

- A thread in Java is a lightweight unit of a program that executes a block of code independently.

- A program can have more than 1 Thread (block of codes which will execute independently) is called
        Multi-Thread.

- By default, every Java program has at least one thread:
        - the main thread (starts execution from main() method).


    Why do we use Threads?
    -----------------------------------
- Threads allow concurrent execution of two or more tasks, improving efficiency and responsiveness.
- Uses of Threads in Java :-
1. Multitasking → Run multiple tasks in parallel (e.g., file download + UI updates).
2. Performance → Utilize CPU cores efficiently by running multiple operations at once.
3. Responsiveness → In GUI apps, prevents "freezing" while long operations run.
4. Background tasks → Logging, monitoring, or scheduled tasks without blocking main flow.
5. Servers → Each client request can run in a separate thread (e.g., web servers, chat servers).


A thread in Java can exist in any one of the following states at any given time.
A thread lies only in one of the shown states at any instant:

1. New State
2. Runnable State
3. Blocked State
4. Waiting State
5. Timed Waiting State
6. Terminated State


1. **New Thread:** When a new thread is created, it is in the new state.
        The thread has not yet started to run when the thread is in this state.
        When a thread lies in the new state, its code is yet to be run and has not started to execute.

2. **Runnable State:** A thread that is ready to run is moved to a runnable state.
        In this state, a thread might actually be running or it might be
        ready to run at any instant of time. It is the responsibility of the thread scheduler
        to give the thread, time to run. A multi-threaded program allocates a fixed amount of
        time to each individual thread. Each and every thread get a small amount of time to run.
        After running for a while, a thread pauses and gives up the CPU so that other threads can run.

3. **Blocked:** The thread will be in blocked state when it is trying to acquire a lock but
        currently the lock is acquired by the other thread. The thread will move from the blocked
            state to runnable state when it acquires the lock.

4. **Waiting state:** The thread will be in waiting state when it calls wait() method or
        join() method. It will move to the runnable state when other thread will notify
            or that thread will be terminated.

5. **Timed Waiting:** A thread lies in a timed waiting state when it calls a method with a
        time-out parameter. A thread lies in this state until the timeout is completed or until a
        notification is received. For example, when a thread calls sleep or a conditional
        wait, it is moved to a timed waiting state.

6. **Terminated State:** A thread terminates because of either of the following reasons:
        Because it exits normally. This happens when the code of the thread has been
            entirely executed by the program.
        Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.
Thread class
Runnable interface 
both packaged at java.lang
To create a new thread, your program will either extend Thread or implement the Runnable interface. 
final String getName( ) Obtains a thread’s name. 
final int getPriority( ) Obtains a thread’s priority. 
final boolean isAlive( ) Determines whether a thread is still running. 
final void join( ) Waits for a thread to terminate. 
void run( ) Entry point for the thread. 
static void sleep(long milliseconds)Suspends a thread for a specified period of milliseconds. 
void start( ) Starts a thread by calling its run( ) method.
All processes have at least one thread of execution, which is usually called the main thread.
From the main thread, you can create other threads. 

You create a thread by instantiating an object of type Thread.
The Runnable interface abstracts a unit of executable code. 
You can construct a thread on any object that implements the Runnable interface. Runnable defines only one method called run( ).
Inside run( ), you will define the code that constitutes the new thread.

It is important to understand that run( ) can call other methods, use other classes, and declare variables just like the main thread.
The only difference is that run( ) establishes the entry point for another, concurrent thread of execution within your program. 
This thread will end when run( ) returns. 

After you have created a class that implements Runnable, you will instantiate an object of type Thread on an object of that class.
Once created, the new thread will not start running until you call its start( ) method, which is declared within Thread. 
In essence, start( ) executes a call to run( ).
package ex2;

import java.util.Random;
@SuppressWarnings("unused")


public class Counter extends Thread {

	private String threadName;
	private int n;
	private Shared o;				// an instance of Share class

	private static Random rgen = new Random();
	private static int MIN_VALUE = 0;
	private static int MAX_VALUE = 5000;

	// constructor
	public Counter(String threadName, Shared o,int n) {  
		this.threadName=threadName;
		this.o = o;		// referencing to the object "o"
		this.n=n;
	}

	public void run() {
		System.out.println(currentThread().getName() + " arrived!");  // displaying which Thread has started
			try {
				synchronized (this.o) {		// lock mechanism
					if (!this.o.isLocked())    this.o.Lock();  // if not locked, lock it
					else 
						while(this.o.isLocked())		// if it is locked ,
							this.o.wait();			// suspend the thread

					for (int i = 1; i <= n; i++) {
						Thread.sleep(rgen.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);  
						System.out.println(currentThread().getName() + " incremented value " + i);
					   }
							this.o.Open();			// reopen the lock 
							this.o.notifyAll();		// wake up all thread 
					}
			  } catch (Exception e) {  e.printStackTrace();   }
		System.out.println("End of the " + currentThread().getName());
	}
}
package ex1;

import java.util.Random;
@SuppressWarnings("unused")


public class Counter extends Thread {  // Counter class extending the Thread class
	private String threadName; 	   // String attribute 
	private int n;			   // integer attribute ( max.number of iterations) 

	private static Random rgen = new Random();  // rgen instance of Random class
	private static int MIN_VALUE = 0;		  // boundaries from 0 - 5000 
	private static int MAX_VALUE = 5000;

	// constructor
	public Counter(String threadName, int n) {
		this.threadName=threadName;
		this.n = n;
	}

	// overriding 
	public void run() {
		for (int i = 1; i <= n; i++) {
			try {
				Thread.sleep(rgen.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);  // random pause
			} catch (InterruptedException e) {  e.printStackTrace();    }
			System.out.println(currentThread().getName() + " incremented value " + i);  // prints the current Thread name and the value incremented
		}
		System.out.println("End of the " + currentThread().getName() );  // displaying end of current Thread
	}
	
}
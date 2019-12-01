package ex1;

public class TestCounter {
	public static void main(String[] args) {
		// creating two threads 
		Thread t1 = new Counter("Thread1", 5);  
		Thread t2 = new Counter("Thread2", 5);
	
		// invoking run() method
		t1.start();	
		t2.start();
		
		//completing the execution of each thread
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {  e.printStackTrace();  }
		
		System.out.println("The end of TestCounter's main.");  // displaying the end of both threads
	}
}
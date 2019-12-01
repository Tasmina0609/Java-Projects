package ex2;

public class TestCounter {
		public static void main(String[] args) {
			
			Shared obj = new Shared("Object");    // instance of Share class
			
			Thread t1 = new Counter("Thread1", obj,5);  
			Thread t2 = new Counter("Thread2", obj,5);
		
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
				
			} catch (InterruptedException e) {  e.printStackTrace(); }
			
			System.out.println("The end of TestCounter's main.");
		}
}	
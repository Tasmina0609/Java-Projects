package ex2;
@SuppressWarnings("unused")

public class Shared {
	private String s;		// String attribute s
	private boolean isLocked;	// boolean data type attribute
	
	// constructor 
	public Shared(String s) {
		this.s=s;
		setLocked(false);  // isLocked == to false 
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isLocked() {	 // returning the state of the lock whether locked/unlocked
		return isLocked;  
	}

	public synchronized void Lock() {  // Lock() is to lock the block 
		this.isLocked = true;
	}

	public synchronized void Open() {   // Open() is to reopen the lock
		this.isLocked = false;
	}
}
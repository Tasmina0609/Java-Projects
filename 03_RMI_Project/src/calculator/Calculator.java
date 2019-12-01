package calculator; 

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	public int operation(String buf) throws RemoteException, NumberFormatException; // method to solve a given mathematical
																		// expression
}

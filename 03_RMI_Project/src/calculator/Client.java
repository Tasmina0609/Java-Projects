package calculator; 
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		System.out.println("Enter the mathematical expression : ");
		Scanner scanner = new Scanner(System.in); // Scanner to input

		try {
			Registry registry = LocateRegistry.getRegistry(Server.MACHINE, Server.PORT); // registry created
			Calculator stub;
			stub = (Calculator) registry.lookup(" Calculate ");
			String buf = scanner.nextLine();
			System.out.println("The client recieved : " + stub.operation(buf)); // invoking the operation() to perform
																				// evaluation
		} catch (NotBoundException e) { e.printStackTrace(); }
		  catch (RemoteException e) {
			System.err.println(" Client exception : " + e);
		} catch (NumberFormatException e) {
			System.err.println("Operands must be numeric!");
		}
		scanner.close();
	}
}

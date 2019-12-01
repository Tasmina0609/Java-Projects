package calculator; 
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Server {

	public static final int PORT = 1099;
	public static final String MACHINE = "localhost";
	
	public static void main(String[] args) {

		try {
			Calculator skeleton = (Calculator) UnicastRemoteObject.exportObject(new CalculatorImpl(), 0); // skeleton
																											// created
			System.out.println("Server is ready");

			Registry registry = LocateRegistry.getRegistry(PORT); // registry created

			if (!Arrays.asList(registry.list()).contains(" Calculate ")) // checking if the registry list contains
																			// "Calculate"
				registry.bind(" Calculate ", skeleton); // binding skeleton under "Calculator" name
			else
				registry.rebind(" Calculate ", skeleton); // rebinding skeleton under "Calculator" name

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

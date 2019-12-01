package calculator; 
import java.rmi.RemoteException;

public class CalculatorImpl implements Calculator {

	@Override
	public int operation(String buf)
			throws RemoteException, NumberFormatException {

		String[] tokens = buf.split(" "); // split into subarrays by detecting space in string
		int op1 = Integer.parseInt(tokens[0]); // convertion to integer op1
		char oper = tokens[1].charAt(0); // operand converted to char
		int op2 = Integer.parseInt(tokens[2]); // convertion to integer op2

		int res = -1;
        if (op1 > 0 && op2 > 0) {
			switch (oper) {
			case '+':
				res = op1 + op2;
				break;
			case '-':
				if (op1 >= op2)
					res = op1 - op2;
				break;
			case '*':
				res = op1 * op2;
				break;
			case '/':
				try {
					res = op1 / op2;
				} catch (ArithmeticException e) {
				} // in case if op2 == 0,not divisible by 0
				break;
			default:
				System.out.println("Wrong operand");
			}
		}
		return res;
	}

}

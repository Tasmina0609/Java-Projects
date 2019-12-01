package network_calc;

import java.io.*;
import java.net.*;

public class Server {
	public static final int PORT = 6666;

	public static void main(String args[]) throws NumberFormatException, IOException {

		ServerSocket serversocket = null; // socket of server
		Socket client; // socket of client
		BufferedReader in; // to read the text ( operation performed on 2 integers)
		PrintWriter out; // to send ( the result of operation)

		try {

			serversocket = new ServerSocket(PORT); // serversocket is set to PORT=6666
			System.out.println("The server is listening to port " + PORT);

			while (true) {
				client = serversocket.accept(); // client accepts the given serversocket
				System.out.println("The client is conneceted");

				in = new BufferedReader(new InputStreamReader(client.getInputStream())); // read from , getInputStream -
																							// place from where you want to read
				String buf = in.readLine(); // reads line of the text
				int res = operation(buf); // res is the result

				out = new PrintWriter(client.getOutputStream()); // to send data
				out.println(Integer.toString(res)); // prints String thats why converted from integer to String
				out.flush(); // flushes stream
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serversocket.close();
		}
	}

	public static int operation(String buf) {
		String[] tokens = buf.split(" ");

		int op1 = Integer.parseInt(tokens[0]);
		char oper = tokens[1].charAt(0);
		int op2 = Integer.parseInt(tokens[2]);

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
				if (op2 != 0)
					res = op1 / op2;
				break;
			default:
			}
			// return res;
		}
		return res;
	}

}
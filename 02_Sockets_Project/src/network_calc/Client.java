package network_calc;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		Scanner scanner = new Scanner(System.in);

		try {

			socket = new Socket(InetAddress.getLocalHost(), Server.PORT);// client socket connects to PORT=6666 at
																			// specified IP adress
			System.out.println("Enter integer1 OPERATION integer2: ");

			// #1
			out = new PrintWriter(socket.getOutputStream()); // sending data to server...getOutputStream()
			String input = scanner.nextLine(); // input is the string of the current line.
			out.println(input); // sends characters followed by line separator characters.
			out.flush(); // flushes the stream

			// the server is replying
			// #4
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();
			System.out.println("The result is: " + response);

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
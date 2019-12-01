package io_streams;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import io_streams.MyShape.TYPE;

public class FileOperations {

	public static void writeToFile(String filename, List<MyShape> list) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter(filename, false)); // opening the stream pw to write to the file.
																			// Append set on false
		String line = null;

		for (MyShape item : list) {// for every shape from the list of shapes do:
			TYPE type = item.getType(); // function of MyShape

			//writing data in csv format
			line = type + "\t" + item.getColor() + "\t" + item.getX() + "\t" + item.getY() + "\t" + item.getWidth()
					+ '\t' + item.getHeight();
			pw.println(line);//write line into file
		}
		pw.close(); // closing the stream pw
	}

	public static void readFromFile(String filename, List<MyShape> list) throws IOException {
		FileInputStream fis = new FileInputStream(new File(filename)); //to read bytes from file 
		InputStreamReader isr = new InputStreamReader(fis); // convert bytes ti characters
		BufferedReader br = new BufferedReader(isr); //read 

		String line = null; //Initializing an empty string 

		while (true) {
			line = br.readLine(); //filling 
			if (line == null) //if noting is inside of file then skip this procedure
				break;

			String[] tokens = line.split("\t"); //splitting csv according to regex

			//valueOf translates string toaccording type
			TYPE type = TYPE.valueOf(tokens[0]); //to type TYPE //read shape
			Color color = new Color(Integer.valueOf(tokens[1])); //to type Color(with rgb integer) //read color
			int x = Integer.valueOf(tokens[2]); //to type int //read x position 
			int y = Integer.valueOf(tokens[3]);//to type int //read y position 

			int w = Integer.valueOf(tokens[4]);//to type int //read width of the shape 
			int h = Integer.valueOf(tokens[5]);//to type int //read heigth of the shape 

			switch (type) {//adding shapes into List of MyShape objects
			case CIRCLE:
				list.add(new Circle(color, x+w/2, y+w/2, w));
				break;
			case RECT:
				list.add(new Rectangle(color, x+w/2, y+h/2, w, h));
				break;
			default:
				break;
			}

		}

		//closing the streams
		br.close(); 
		isr.close();
		fis.close();
	}
}

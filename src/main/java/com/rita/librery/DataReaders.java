package com.rita.librery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class DataReaders {
	// scanner to read the txt files of reader... people who are going to read the
	// books

	public DataReaders() {
		String c = File.separator;
		File file = null;
		String fileName = "data" + c + "Books.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			try {
				file = new File(resource.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}

		System.out.println(file.getAbsolutePath());
		try {
			BufferedReader readersR = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String contentReaders = readersR.readLine();

			String[] dataR;// create an array of string that is going to hold the dataR

			int ID;
			String nameReader;
			String surnameR;
			String address;
			int age;

			while (contentReaders != null) { // while the content of the readers is not null...

				dataR = contentReaders.split(","); // split the data by comes
				ID = Integer.parseInt(dataR[0]); // the ids at position 0, have to be converted to integer numbers
				nameReader = dataR[1];
				surnameR = dataR[2];
				address = dataR[3];
				age = Integer.parseInt(dataR[0]);
				// with this i will print the ID and the names
				System.out.println("Reader ID number: " + ID + ", " + nameReader);
//				System.out.println(contentReaders); // print all the list of readers

				contentReaders = readersR.readLine();
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

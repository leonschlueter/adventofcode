package util;

import java.io.*;
import java.util.*;

public class InputReader {

	InputStream f;

	public InputReader(String fileName) {
		System.out.println("Reading from: " + fileName);
		this.f = InputReader.class.getResourceAsStream("/resources/" + fileName);
		if (this.f == null) {
			throw new NullPointerException("name");
		}
	}

	public ArrayList<Integer> readIntegerList() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextInt()) {
			arr.add(s.nextInt());
		}
		s.close();
		return arr;
	}

	public ArrayList<String> readStringList() {
		ArrayList<String> arr = new ArrayList<String>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextLine()) {
			arr.add(s.nextLine());
		}
		s.close();
		return arr;
	}
}

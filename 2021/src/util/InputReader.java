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

	public ArrayList<Integer> splitIntegerList(char c) {
		Scanner s = new Scanner(this.f);
		String[] str = s.next().split(",");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < str.length; i++) {
			arr.add(Integer.parseInt(str[i]));
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

	public ArrayList<int[][][]> createThreeDMatrix() {
		ArrayList<int[][][]> cards = new ArrayList<int[][][]>();
		Scanner s = new Scanner(this.f);
		while (s.hasNext()) {
			int[][][] card = new int[5][5][2];
			for (int i = 0; i < card.length; i++) {
				for (int j = 0; j < card.length; j++) {
					card[i][j][0] = s.nextInt();
					card[i][j][1] = 0;
				}
			}
			cards.add(card);
		}

		return cards;
	}
}

package util;

import java.io.*;
import java.util.*;

public class InputReader {

	InputStream f;
	long time;
	public long lastTime;

	public InputReader(String fileName) {
		System.out.println("Reading from: " + fileName);
		this.f = InputReader.class.getResourceAsStream("/resources/" + fileName);
		if (this.f == null) {
			throw new NullPointerException("name");
		}
		this.time = System.currentTimeMillis();
		this.lastTime = 0;
	}

	public ArrayList<Integer> readIntegerList() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextInt()) {
			arr.add(s.nextInt());
		}
		s.close();
		createTime();
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
	public ArrayList<String[]> splitStringList() {
		Scanner s = new Scanner(this.f);
		
		ArrayList<String[]> arr = new ArrayList<String[]>();
		while(s.hasNextLine()) {
			String[] str = s.nextLine().split("");
			arr.add(str);
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
		createTime();
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
		createTime();
		return cards;
	}

	public ArrayList<Line> createLineArray() {
		ArrayList<Line> lines = new ArrayList<Line>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextLine()) {
			String[] str = s.nextLine().split(" -> ");
			int[] input = new int[4];
			for (int i = 0; i < str.length; i++) {
				String c = str[i];
				String[] arr = c.split(",");

				input[0 + 2 * i] = Integer.parseInt(arr[0]);
				input[1 + 2 * i] = Integer.parseInt(arr[1]);

			}

			Point p1 = new Point(input[0], input[1]);
			Point p2 = new Point(input[2], input[3]);
			if (p1.x > p2.x) {
				Line l = new Line(p2, p1);
				lines.add(l);
			} else {
				Line l = new Line(p1, p2);
				lines.add(l);
			}

		}
		s.close();
		createTime();
		return lines;
	}

	public ArrayList<String[]> giveEight() {
		ArrayList<String[]> arr = new ArrayList<String[]>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextLine()) {
			String[] line = new String[14];
			String sp = s.nextLine();
			String split = sp.replace(" | ", " ");
			split = split.trim().replace("  ", " ");
			line = split.split(" ");
			arr.add(line);
		}
		for (String[] list : arr) {
			for (int i = 0; i < list.length; i++) {
				char[] charArray = list[i].toCharArray();
				Arrays.sort(charArray);
				list[i] = new String(charArray);

			}
		}
		createTime();
		return arr;
	}

	public ArrayList<int[]> give2DArray() {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextLine()) {
			String str = s.nextLine();
			
			int[] line = new int[str.length()];
			String[] p = str.split("");
			int i = 0;
			for (String c : p) {
				line[i] = Integer.parseInt(p[i]);
				i++;
			}
			arr.add(line);
		}
		s.close();
		createTime();
		return arr;
	}

	public void print2Darray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void createTime() {
		this.lastTime = System.currentTimeMillis() - time;
		System.out.println("Input time taken: " + lastTime + "ms");
	}
}

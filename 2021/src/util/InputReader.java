package util;

import java.io.*;
import java.util.*;

public class InputReader {

	InputStream f;
	long time;
	public long lastTime;
	public LinkedList<Character> res;

	public InputReader(String fileName) {
		System.out.println("Reading from: " + fileName);
		this.f = InputReader.class.getResourceAsStream("/resources/" + fileName);
		if (this.f == null) {
			throw new NullPointerException("name");
		}
		this.time = System.currentTimeMillis();
		this.lastTime = 0;
		this.res = new LinkedList<Character>();
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
		while (s.hasNextLine()) {
			String[] str = s.nextLine().split("");
			arr.add(str);
		}
		s.close();

		return arr;
	}

	public ArrayList<ArrayList<String>> splitString() {
		Scanner s = new Scanner(this.f);

		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		while (s.hasNextLine()) {

			String[] str = s.nextLine().split("-");
			boolean isInA = false;
			boolean isInB = false;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).get(0).equals(str[0])) {
					isInA = true;
					arr.get(i).add(str[1]);
				}
				if (arr.get(i).get(0).equals(str[1])) {
					isInB = true;
					arr.get(i).add(str[0]);
				}
			}
			if (!isInA) {
				ArrayList<String> n = new ArrayList<String>();
				n.add(str[0]);
				n.add(str[1]);
				arr.add(n);
			}
			if (!isInB) {
				ArrayList<String> n = new ArrayList<String>();
				n.add(str[1]);
				n.add(str[0]);
				arr.add(n);
			}
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
		s.close();
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
		s.close();
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

	public ArrayList<int[]> giveFoldingArray() {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		Scanner s = new Scanner(this.f);
		while (s.hasNextLine()) {
			String str = s.nextLine();
			String[] coords = str.split(",");
			if (str.equals("")) {
				break;
			}
			int[] ar = new int[2];
			ar[0] = Integer.parseInt(coords[0]);
			ar[1] = Integer.parseInt(coords[1]);
			arr.add(ar);
		}
		int[] sp = { Integer.MAX_VALUE };
		arr.add(sp);
		while (s.hasNextLine()) {
			String str = s.nextLine();
			String[] sA = str.split("fold along ");
			String[] op = sA[1].split("=");
			int[] ope = new int[2];
			if (op[0].equals("x")) {
				ope[0] = 0;
			} else {
				ope[0] = 1;
			}
			ope[1] = Integer.parseInt(op[1]);
			arr.add(ope);
		}
		s.close();
		createTime();
		return arr;
	}

	public HashMap<String, String> getFourTeen() {
		Scanner s = new Scanner(this.f);
		String beg = s.nextLine();

		for (int i = 0; i < beg.length(); i++) {
			this.res.add(beg.charAt(i));
		}
		s.nextLine();
		HashMap<String, String> map = new HashMap<String, String>();
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] sp = line.split(" -> ");
			map.put(sp[0], sp[1]);
		}

		s.close();
		return map;
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

package days;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputReader;

public class DayThirteen {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("selfTests.txt");
		ArrayList<int[]> arr = ir.giveFoldingArray();
		long beginTime = System.currentTimeMillis();

		// Task A:
		int sp = 0;
		for (int[] a : arr) {
			if (a[0] == Integer.MAX_VALUE) {
				break;
			}
			sp++;
		}
		int x = 0;
		int y = 0;
		int[][] coord = new int[sp][2];
		for (int i = 0; i < coord.length; i++) {
			for (int j = 0; j < coord[0].length; j++) {

				if (j == 1) {
					if (arr.get(i)[j] >= x) {
						x = arr.get(i)[j];
					}
					coord[i][0] = arr.get(i)[j];
				}
				if (j == 0) {
					if (arr.get(i)[j] >= y) {
						y = arr.get(i)[j];
					}
					coord[i][1] = arr.get(i)[j];
				}
			}
		}
		x++;
		y++;
		sp++;
		System.out.println(x + " " + y);
		int[][] instr = new int[arr.size() - sp][2];
		for (int i = 0; i < instr.length; i++) {
			for (int j = 0; j < instr[0].length; j++) {
				instr[i][j] = arr.get(i + sp)[j];
			}
		}

		char[][] lattice = new char[x][y];
		for (int i = 0; i < lattice.length; i++) {
			for (int j = 0; j < lattice[0].length; j++) {
				lattice[i][j] = '.';
			}
		}
		for (int i = 0; i < coord.length; i++) {
			lattice[coord[i][0]][coord[i][1]] = '#';
		}
		for (char[] a : lattice) {
			// System.out.println(Arrays.toString(a));
		}
		System.out.println(count(lattice));
		int resA = 0;
		for (int i = 0; i < instr.length; i++) {
			System.out.println("Fold: " + i);
			lattice = foldAt(lattice, instr[i][0], instr[i][1]);
			System.out.println("================");
			if (i == 0) {
				resA = count(lattice);
			}
		}

		System.out.println(lattice.length + " " + lattice[0].length);
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + resA);

		beginTime = System.currentTimeMillis();
		// Task B:

		printArray(lattice);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static char[][] foldAt(char[][] lattice, int axis, int height) {
		// x = 1, y = 0
		int latX = lattice.length;
		int latY = lattice[1].length;
		char[][] lat;

		if (axis == 1) {
			lat = new char[height][latY];
		} else {
			lat = new char[latX][height];
		}

		for (int i = 0; i < lat.length; i++) {
			for (int j = 0; j < lat[0].length; j++) {
				lat[i][j] = lattice[i][j];
			}
		}
		lat = addMirroredPoints(lat, lattice, height, axis);
		return lat;
	}

	private static char[][] addMirroredPoints(char[][] lat, char[][] lattice, int height, int axis) {
		System.out.println("Height: " + height);
		System.out.println("Lat: " + lat.length + " " + lat[0].length);
		if (axis == 0) {
			for (int i = 0; i < lattice.length; i++) {
				for (int j = height + 1; j < lattice[0].length; j++) {
					if (lattice[i][j] == '#') {
						lat[i][2 * height - j] = '#';
					}
				}
			}
		} else {
			for (int i = height + 1; i < lattice.length; i++) {
				for (int j = 0; j < lattice[0].length; j++) {
					if (lattice[i][j] == '#') {
						lat[2 * height - i][j] = '#';
					}
				}
			}
		}

		return lat;
	}

	private static int count(char[][] lattice) {
		int resA = 0;
		for (int i = 0; i < lattice.length; i++) {
			for (int j = 0; j < lattice[0].length; j++) {
				if (lattice[i][j] == '#') {
					resA++;
				}
			}
		}
		return resA;
	}

	static void printArray(char[][] c) {
		for (char[] ch : c) {
			for (int i = 0; i < ch.length; i++) {
				String str = "";
				if (ch[i] == '#') {
					str += "\033[0;31m";
				}

				System.out.print(str + ch[i] + " \033[0m");

			}
			System.out.println();
			}
		}
}

package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import util.InputReader;

public class DayEight {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayEight.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<String[]> arr = ir.giveEight();
		// Task A:
		int co = 0;
		for (String[] list : arr) {
			for (int i = 10; i < list.length; i++) {
				if (list[i].length() == 2 || list[i].length() == 4 || list[i].length() == 3 || list[i].length() == 7) {
					co++;
				}
			}
		}
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + co);
		beginTime = System.currentTimeMillis();
		// Task B:
		int sum = 0;
		for (String[] list : arr) {
			String[] interpretations = new String[10];
			int[][] table = new int[10][7];
			interpretations = findObvious(list);

			table[1] = convertToBytes(interpretations[1]);
			table[4] = convertToBytes(interpretations[4]);
			table[7] = convertToBytes(interpretations[7]);
			table[8] = convertToBytes(interpretations[8]);

			int[] a = without(table[7], table[1]);
			int[] bd = and(not(table[1]), table[4]);
			int[] eg = without(without(table[8], table[7]), bd);
			int[] bdeg = or(bd, eg);
			table[6] = findSix(list, bdeg, table);
			table[5] = findFive(list, table[6], table);
			int[] e = without(table[6], table[5]);
			int[] g = without(eg, e);
			table[9] = or(or(table[4], g), a);
			int[] c = without(table[8], table[6]);
			int[] aceg = or(or(a, c), eg);
			table[2] = findTwo(list, aceg, table);
			int[] d = without(table[2], aceg);
			table[3] = or(table[1], or(a, or(g, d)));
			table[0] = without(table[8], d);

			String s = "";
			for (int i = 10; i < 14; i++) {
				s += (int) findDigit(list[i], table);
			}
			sum += Integer.parseInt(s);
		}

		System.out.println("Task B: " + sum);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");

	}

	private static int findDigit(String string, int[][] table) {
		int[] arr = convertToBytes(string);
		for (int i = 0; i < 10; i++) {
			if (Arrays.equals(arr, table[i])) {
				return i;
			}
		}
		return -1;
	}

	private static int[] findTwo(String[] list, int[] aceg, int[][] table) {
		for (int i = 0; i < list.length; i++) {
			int[] binVal = convertToBytes(list[i]);
			int sum = 0;
			for (int j = 0; j < 7; j++) {
				if (binVal[j] == 1) {
					sum++;
				}
			}
			int[] nul = without(binVal, aceg);
			int c = 0;
			for (int j = 0; j < nul.length; j++) {
				if (nul[j] == 1) {
					c++;
				}
			}
			if (c == 1 && sum == 5)
				return binVal;
		}
		return null;
	}

	private static int[] findSix(String[] list, int[] include, int[][] table) {
		for (int i = 0; i < list.length; i++) {
			int[] binVal = convertToBytes(list[i]);
			int[] nul = without(include, binVal);
			int c = 0;
			for (int j = 0; j < nul.length; j++) {
				if (nul[j] == 0) {
					c++;
				}
			}
			if (c == 7 && !Arrays.equals(binVal, table[8]))
				return binVal;
		}
		return null;
	}

	private static int[] findFive(String[] list, int[] six, int[][] table) {
		for (int i = 0; i < list.length; i++) {
			int[] binVal = convertToBytes(list[i]);
			int[] nul = without(six, binVal);
			int sum = 0;
			for (int j = 0; j < binVal.length; j++) {
				if (binVal[j] == 1)
					sum++;
			}
			int c = 0;
			for (int j = 0; j < nul.length; j++) {
				if (nul[j] == 1) {
					c++;
				}
			}
			if (c == 1 && sum == 5)
				return binVal;
		}
		return null;
	}

	private static int[] not(int[] a) {
		int[] res = new int[7];
		for (int i = 0; i < res.length; i++) {
			if (a[i] == 1) {
				res[i] = 0;
			} else {
				res[i] = 1;
			}
		}
		return res;
	}

	private static int[] without(int[] a, int[] b) {
		int[] res = new int[7];
		for (int i = 0; i < res.length; i++) {
			if (a[i] == 1 && b[i] == 1) {
				res[i] = 0;
			} else if (a[i] == 1) {
				res[i] = 1;
			}
		}
		return res;
	}

	private static int[] and(int[] a, int[] b) {
		int[] res = new int[7];
		for (int i = 0; i < res.length; i++) {
			if (a[i] == 1 && b[i] == 1) {
				res[i] = 1;
			}
		}
		return res;
	}

	private static int[] or(int[] a, int[] b) {
		int[] res = new int[7];
		for (int i = 0; i < res.length; i++) {
			if (a[i] == 1 || b[i] == 1) {
				res[i] = 1;
			}
		}
		return res;
	}

	private static int[] convertToBytes(String s) {
		int[] bin = new int[7];
		char[] cA = s.toCharArray();
		for (char c : cA) {
			bin[c - 'a'] = 1;
		}
		return bin;
	}

	private static String[] findObvious(String[] list) {
		String[] interpretations = new String[10];
		interpretations[1] = findOne(list);
		interpretations[4] = findFour(list);
		interpretations[7] = findSeven(list);
		interpretations[8] = "abcdefg";
		return interpretations;
	}

	private static String findSeven(String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() == 3) {
				return list[i];
			}
		}
		return null;
	}

	private static String findFour(String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() == 4) {
				return list[i];
			}
		}
		return null;
	}

	private static String findOne(String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() == 2) {
				return list[i];
			}
		}
		return null;
	}
}

package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.InputReader;

public class DayEleven {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayEleven.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<int[]> input = ir.give2DArray();

		ArrayList<int[]> inB = new ArrayList<int[]>();
		for (int i = 0; i < input.size(); i++) {
			int[] n = new int[input.get(i).length];
			for (int j = 0; j < n.length; j++) {
				n[j] = input.get(i)[j];
			}

			inB.add(n);
		}

		// Task A:
		String[][] s = new String[input.size()][input.get(0).length];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				s[i][j] = "O";
			}
		}
		int[] count = { 0, 0 };
		input.add(count);
		for (int i = 0; i < 100; i++) {
			input = oneRound(input, s, 0);
		}

		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + input.get(input.size() - 1)[0]);
		beginTime = System.currentTimeMillis();
		// Task B:

		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				s[i][j] = "O";
			}
		}
		int[] count2 = { 0, 0 };
		inB.add(count2);
		int r = 1;
		while (inB.get(inB.size() - 1)[1] == 0) {
			inB = oneRound(inB, s, r);
			r++;
		}

		System.out.println("Task B: " + inB.get(inB.size() - 1)[1]);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static void createInput(ArrayList<int[]> input) {
		for (int[] arr : input) {
			System.out.print("[ ");
			for (int j = 0; j < arr.length; j++) {
				String str = "";
				if (arr[j] == 0) {
					str += "\033[0;31m";
				}

				System.out.print(str + arr[j] + " \033[0m");

			}
			System.out.print("]");
			System.out.println();
		}
	}

	private static void stringPrint(String[][] input) {
		for (String[] arr : input) {
			System.out.print("[ ");
			for (int j = 0; j < arr.length; j++) {
				String str = "";
				if (arr[j].equals("X")) {
					str += "\033[0;31m";
				}

				System.out.print(str + arr[j] + " \033[0m");

			}
			System.out.print("]");
			System.out.println();
		}
	}

	private static ArrayList<int[]> oneRound(ArrayList<int[]> input, String[][] s, int round) {
		input = increaseByOne(input);
		input = checkForFlash(input, s);
		input = flashIfP(input, s);
		input = seeIfFlashed(input, s, round);

		return input;
	}

	private static ArrayList<int[]> flashIfP(ArrayList<int[]> input, String[][] s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < input.size() - 1; i++) {
			int[] arr = input.get(i);
			for (int j = 0; j < arr.length; j++) {
				if (s[i][j].equals("P")) {
					flash(input, i, j, s);
				}
			}
		}
		return input;

	}

	private static ArrayList<int[]> checkForFlash(ArrayList<int[]> input, String[][] s) {
		for (int i = 0; i < input.size() - 1; i++) {
			int[] arr = input.get(i);
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > 9 && !s[i][j].equals("X")) {
					s[i][j] = "P";
				}
			}
		}
		return input;
	}

	private static ArrayList<int[]> seeIfFlashed(ArrayList<int[]> input, String[][] s, int round) {
		boolean all = true;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (s[i][j].equals("X")) {
					input.get(i)[j] = 0;
				} else {
					all = false;
				}
				s[i][j] = "O";
			}
		}
		if (all) {
			input.get(input.size() - 1)[1] = round;
		}
		return input;
	}

	private static ArrayList<int[]> flash(ArrayList<int[]> input, int i, int j, String[][] s) {
		s[i][j] = "X";
		input.get(input.size() - 1)[0]++;
		for (int k = -1; k < 2; k++) {
			for (int k2 = -1; k2 < 2; k2++) {
				int indX = i + k;
				int indY = k2 + j;
				if (indX >= 0 && indX < input.size() - 1 && indY >= 0 && indY < input.get(1).length) {
					input.get(indX)[indY]++;
				}
			}
		}
		input = checkForFlash(input, s);
		input = flashIfP(input, s);

		return input;
	}

	private static ArrayList<int[]> increaseByOne(ArrayList<int[]> input) {
		for (int[] arr : input) {

			if (arr.length == 2) {
				break;
			}

			for (int i = 0; i < arr.length; i++) {
				arr[i]++;
			}

		}

		return input;
	}
}

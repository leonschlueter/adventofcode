package days;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputReader;

public class DayNine {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayNine.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<int[]> mat = ir.give2DArray();
		// Task A:
		int res = findLowPoints(mat);

		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Result Task A: " + res);
		beginTime = System.currentTimeMillis();
		// Task B:

		ArrayList<int[]> low = findLowPointsList(mat);
		int[] max = new int[low.size()];
	
		for (int i = 0; i < low.size(); i++) {
			int[] coord = low.get(i);
			int c = 0;
			char[][] debug = new char[mat.size()][mat.get(0).length];
			for (int j = 0; j < debug.length; j++) {
				for (int k = 0; k < debug[0].length; k++) {
					debug[j][k] = '0';
				}
			}
			max[i] = findBasin(mat, coord[0], coord[1], debug);
		}
		// System.out.println(Arrays.toString(max));

		Arrays.sort(max);
		int i = max.length - 1;
		System.out.println("Result Task B: " + (max[i] * max[i - 1] * max[i - 2]));

		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static int findLowPoints(ArrayList<int[]> arr) {
		int c = 0;
		for (int i = 0; i < arr.size(); i++) {
			int[] l = arr.get(i);
			for (int j = 0; j < l.length; j++) {
				if (i != 0 && i != arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j + 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])
							&& (arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {
						c += arr.get(i)[j] + 1;
					}
				}

				if (i == 0) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					}
				}
				if (i == arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					} else {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {
							c += arr.get(i)[j] + 1;
						}
					}
				}

			}
		}
		return c;
	}

	private static ArrayList<int[]> findLowPointsList(ArrayList<int[]> arr) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < arr.size(); i++) {
			int[] l = arr.get(i);
			for (int j = 0; j < l.length; j++) {
				int[] res = new int[2];
				res[0] = i;
				res[1] = j;

				if (i != 0 && i != arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j + 1] > arr.get(i)[j])) {
							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {
							list.add(res);
						}
					} else if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])
							&& (arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {
						list.add(res);
					}
				}

				else if (i == 0) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {
							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {

							list.add(res);
						}
					} else {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {

							list.add(res);
						}
					}
				} else if (i == arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {

							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {

							list.add(res);
						}
					} else {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {

							list.add(res);
						}
					}
				}

			}
		}
		return list;
	}

	private static ArrayList<int[]> findLowPointsNew(ArrayList<int[]> arr) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).length; j++) {
				boolean up = false;
				boolean down = false;
				boolean left = false;
				boolean right = false;
				boolean isLow = true;
				if (i > 1) {
					up = true;
				}
				if (i < arr.size() - 1) {
					down = true;
				}
				if (j > 1) {
					left = true;
				}
				if (j < arr.get(1).length - 1) {
					right = true;
				}

				if (up && arr.get(i)[j] > arr.get(i - 1)[j]) {
					isLow = false;
				}
				if (down && arr.get(i)[j] > arr.get(i + 1)[j]) {
					isLow = false;
				}
				if (left && arr.get(i)[j] > arr.get(i)[j - 1]) {
					isLow = false;
				}
				if (right && arr.get(i)[j] > arr.get(i)[j + 1]) {
					isLow = false;
				}

				if (isLow) {
					int[] a = new int[2];
					a[0] = i;
					a[1] = j;
					res.add(a);
				}
			}
		}

		return res;
	}

	public static int findBasin(ArrayList<int[]> arr, int x, int y, char[][] debug) {
		//System.out.println("Added Point: " + x + " " + y);

		debug[x][y] = 'X';
		int size = 1;
		size += sizeOfUpper(arr, x - 1, y, debug);
		if (sizeOfUpper(arr, x - 1, y, debug) >= 1) {
			// System.out.println("Added upper Point: "+(x-1)+" "+y);
		}
		size += sizeOfLower(arr, x + 1, y, debug);
		size += sizeOfRight(arr, x, y + 1, debug);
		size += sizeOfLeft(arr, x, y - 1, debug);
		return size;
	}

	private static int sizeOfUpper(ArrayList<int[]> arr, int x, int y, char[][] debug) {
		if (x == -1 || arr.get(x)[y] < arr.get(x + 1)[y] + 1 || arr.get(x)[y] == 9 || debug[x][y] == 'X') {
			return 0;
		}
		else
		return findBasin(arr, x, y, debug);
	}

	private static int sizeOfLower(ArrayList<int[]> arr, int x, int y, char[][] debug) {

		if (x == arr.size() || arr.get(x)[y] < arr.get(x - 1)[y] + 1 || arr.get(x)[y] == 9 || debug[x][y] == 'X') {
			return 0;
		}else
		return findBasin(arr, x, y, debug);
	}

	private static int sizeOfRight(ArrayList<int[]> arr, int x, int y, char[][] debug) {
		if (y == arr.get(x).length || arr.get(x)[y] < arr.get(x)[y - 1] || arr.get(x)[y] == 9
				|| debug[x][y] == 'X') {
			return 0;
		}else
		return findBasin(arr, x, y, debug);
	}

	private static int sizeOfLeft(ArrayList<int[]> arr, int x, int y, char[][] debug) {
		if (y == -1 || arr.get(x)[y] < arr.get(x)[y + 1]  || arr.get(x)[y] == 9 || debug[x][y] == 'X') {
			return 0;
		}else
		return findBasin(arr, x, y, debug);
	}
}

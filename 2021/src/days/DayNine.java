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
			for (int i1 = 0; i1 < debug.length; i1++) {
				for (int j = 0; j < debug[0].length; j++) {
					debug[i1][j] = '0';
				}
			}
			findBasin(mat, coord[0], coord[1], debug, 0);
			for (int i1 = 0; i1 < debug.length; i1++) {
				// System.out.println(Arrays.toString(debug[i1]));
				for (int j = 0; j < debug[i1].length; j++) {
					if (debug[i1][j] == 'X') {
						c++;
					}
				}
			}

			max[i] = c;
		}
		// System.out.println(Arrays.toString(max));

		Arrays.sort(max);
		int i = max.length - 1;
		System.out.println(Arrays.toString(max));
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
				if (i != 0 && i != arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j + 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && arr.get(i - 1)[j] > arr.get(i)[j]
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])
							&& (arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {

						res[0] = i;
						res[1] = j;
						list.add(res);
					}
				}

				else if (i == 0) {
					if (j == 0) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else {
						if ((arr.get(i + 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {
							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					}
				} else if (i == arr.size() - 1) {
					if (j == 0) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else if (j == l.length - 1) {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j - 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					} else {
						if ((arr.get(i - 1)[j] > arr.get(i)[j]) && (arr.get(i)[j + 1] > arr.get(i)[j])
								&& (arr.get(i)[j - 1] > arr.get(i)[j])) {

							res[0] = i;
							res[1] = j;
							list.add(res);
						}
					}
				}

			}
		}
		return list;
	}

	public static int findBasin(ArrayList<int[]> arr, int x, int y, char[][] debug, int size) {

		debug[x][y] = 'X';

		// System.out.println("Point: " + x + " " + y);
		// System.out.println(size);
		size += sizeOfUpper(arr, x - 1, y, debug, size);
		size += sizeOfLower(arr, x + 1, y, debug, size);
		size += sizeOfRight(arr, x, y + 1, debug, size);
		size += sizeOfLeft(arr, x, y - 1, debug, size);
		return size;
	}

	private static int sizeOfUpper(ArrayList<int[]> arr, int x, int y, char[][] debug, int size) {
		if (x == -1 || arr.get(x)[y] != arr.get(x + 1)[y] + 1 || arr.get(x)[y] == 9) {
			return 0;
		}

		return findBasin(arr, x, y, debug, size);
	}

	private static int sizeOfLower(ArrayList<int[]> arr, int x, int y, char[][] debug, int size) {

		if (x == arr.size() || arr.get(x)[y] != arr.get(x - 1)[y] + 1 || arr.get(x)[y] == 9) {
			return 0;
		}
		return findBasin(arr, x, y, debug, size);
	}

	private static int sizeOfRight(ArrayList<int[]> arr, int x, int y, char[][] debug, int size) {
		// TODO Auto-generated method stub
		if (y == arr.get(x).length || arr.get(x)[y] != arr.get(x)[y - 1] + 1 || arr.get(x)[y] == 9) {
			return 0;
		}
		return findBasin(arr, x, y, debug, size);
	}

	private static int sizeOfLeft(ArrayList<int[]> arr, int x, int y, char[][] debug, int size) {
		// TODO Auto-generated method stub
		if (y == -1 || arr.get(x)[y] != arr.get(x)[y + 1] + 1 || arr.get(x)[y] == 9) {
			return 0;
		}
		return findBasin(arr, x, y, debug, size);
	}
}

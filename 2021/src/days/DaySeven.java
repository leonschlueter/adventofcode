package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.InputReader;

public class DaySeven {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("daySeven.txt");
		ArrayList<Integer> input = ir.splitIntegerList(',');
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i : input) {
			hm.merge(i, 1, Integer::sum);
		}

		long beginTime = System.currentTimeMillis();

		// Task A:
		int[] fuel = new int[hm.size()];
		for (int i = 0; i < fuel.length; i++) {
			fuel[i] = findFuelSumA(hm, i);
		}
		int sum = arrayMin(fuel);
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Result Task A: " + sum);
		beginTime = System.currentTimeMillis();
		// Task B:
		fuel = new int[hm.size()];
		for (int i = 0; i < fuel.length; i++) {
			fuel[i] = findFuelSumB(hm, i);
		}
		sum = arrayMin(fuel);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("Result Task B: " + sum);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static int arrayMin(int[] fuel) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < fuel.length; i++) {
			if (fuel[i] < min) {
				min = fuel[i];
			}
		}
		return min;
	}

	private static int findFuelSumA(HashMap<Integer, Integer> hm, int p) {
		int f = 0;
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int pos = entry.getKey();
			int num = entry.getValue();

			f += Math.abs(p - pos) * num;

		}
		return f;
	}

	private static int findFuelSumB(HashMap<Integer, Integer> hm, int p) {
		int f = 0;
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int pos = entry.getKey();
			int num = entry.getValue();

			f += gauss(Math.abs(p - pos)) * num;

		}
		return f;
	}

	private static int gauss(int n) {
		return (n * (n + 1)) / 2;
	}
}

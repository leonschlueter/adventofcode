package days;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputReader;

public class DaySix {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("daySix.txt");
		ArrayList<Integer> in = ir.splitIntegerList(',');
		long beginTime = System.currentTimeMillis();
		long[] fish = new long[9];
		long[] fishB = new long[9];
		for (int i : in) {
			fish[i]++;
			fishB[i]++;
		}
		long changeInputTime = System.currentTimeMillis() - beginTime;
		
		// Task A:
		for (int i = 0; i < 80; i++) {
			fish = oneDay(fish);
		}
		long sum = 0;
		for (int i = 0; i < fish.length; i++) {
			sum += fish[i];
		}

		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Result Task A: " + sum);
		
		// Task B:
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < 256; i++) {
			fishB = oneDay(fishB);
		}
		sum = 0;
		for (int i = 0; i < fishB.length; i++) {
			sum += fishB[i];
		}
		System.out.println("Result Task B: " + sum);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		
		//Time Output:
		System.out.println("=====[TIME]=====");
		System.out.println("Time Change Input: " + changeInputTime + "ms");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static long[] oneDay(long[] fish) {
		long[] nextDay = new long[9];
		for (int i = 0; i < fish.length; i++) {
			if (i == 8) {
				nextDay[i] += fish[0];
			} else {
				nextDay[i] += fish[i + 1];
			}
		}
		nextDay[6] += nextDay[8];

		return nextDay;
	}

}

/* Advent of Code 2021
 * Day: One
 * Author: Leon Schlüter
 * 
 */
package days;

import util.InputReader;
import java.util.*;

public class DayOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader ir = new InputReader("dayOne.txt");
		ArrayList<Integer> in = ir.readIntegerList();

		System.out.println("Task A:");
		System.out.println(incCount(in));

		// Create an arraylist with all possible values in order:
		ArrayList<Integer> threeSum = new ArrayList<Integer>();
		for (int i = 0; i < in.size() - 2; i++) {
			threeSum.add(in.get(i) + in.get(i + 1) + in.get(i + 2));
		}
		System.out.println(incCount(threeSum));
	}

	/*
	 * incCount counts how many elements in an ArrayList are bigger than the
	 * previous ones.
	 * 
	 */
	public static int incCount(ArrayList<Integer> a) {
		int inc = 0;
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i - 1) < a.get(i)) {
				inc++;
			}
		}
		return inc;
	}

}

package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import util.InputReader;

public class DayTen {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayTen.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<String[]> arr = ir.splitStringList();

		// Task A:
		int score = 0;
		for (int i = 0; i < arr.size(); i++) {
			String[] a = arr.get(i);
			score += findFirstError(a);
		}
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + score);

		beginTime = System.currentTimeMillis();
		// Task B:
		int b = 0;
		long[] res = new long[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			res[i] = findCompletingOrder(arr.get(i));
		}
		Arrays.sort(res);
		int ind = 0;
		while(res[ind]==0) {
			ind++;
		}
		int median = ((res.length - ind)/2)+ind;
		System.out.println("Task B: " + res[median]);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static long findCompletingOrder(String[] a) {
		Stack<String> stack = new Stack<String>();
		Stack<String> next = new Stack<String>();
		long score = 0;
		boolean notComplete = true;
		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}
		while (!stack.isEmpty()) {
			String b = stack.pop();
			if (b.equals("(") || b.equals("[") || b.equals("{") || b.equals("<")) {
				next.push(b);
			} else {
				String clos = next.peek();
				switch (b) {
				case ")":
					if (clos.equals("(")) {
						next.pop();
					} else {
						notComplete = false;
					}
					break;
				case "]":
					if (clos.equals("[")) {
						next.pop();
					} else {
						notComplete = false;
					}
					break;
				case "}":
					if (clos.equals("{")) {
						next.pop();
					} else {
						notComplete = false;
					}
					break;
				case ">":
					if (clos.equals("<")) {
						next.pop();
					} else {
						notComplete = false;
					}
					break;
				}
			}
		}
		// System.out.println("Not complete: " + notComplete);
		String s = "";
		while (!next.isEmpty() && notComplete) {
			String c = next.pop();
			s = s + c;
			score = 5 * score;
			// System.out.println(score);
			switch (c) {
			case "(":
				// System.out.println("+1");
				score += 1;
				break;
			case "[":
				// System.out.println("+2");
				score += 2;
				break;
			case "{":
				// System.out.println("+3");
				score += 3;
				break;
			case "<":
				// System.out.println("+4");
				score += 4;
				break;
			}
			// System.out.println(score);
		}
		// System.out.println();
		// System.out.println(s+" Score: " + score);
		return score;
	}

	private static int findFirstError(String[] a) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		Stack<String> next = new Stack<String>();
		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}
		while (!stack.isEmpty()) {
			String b = stack.pop();
			if (b.equals("(") || b.equals("[") || b.equals("{") || b.equals("<")) {
				next.push(b);
			} else {
				String clos = next.peek();
				switch (b) {
				case ")":
					if (clos.equals("(")) {
						next.pop();
					} else {
						return 3;
					}
					break;
				case "]":
					if (clos.equals("[")) {
						next.pop();
					} else {
						return 57;
					}
					break;
				case "}":
					if (clos.equals("{")) {
						next.pop();
					} else {
						return 1197;
					}
					break;
				case ">":
					if (clos.equals("<")) {
						next.pop();
					} else {
						return 25137;
					}
					break;
				}

			}
		}
		return 0;
	}

}

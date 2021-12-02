/* Advent of Code 2021
 * Day: Two
 * Author: Leon Schlüter
 * 
 */
package days;

import java.util.ArrayList;

import util.InputReader;

public class DayTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader ir = new InputReader("dayTwo.txt");
		ArrayList<String> in = ir.readStringList();
		String[] moveN = new String[in.size()];
		int[] moveNum = new int[in.size()];
		int c = 0;
		for (String i : in) {
			String[] val = i.split(" ");
			moveN[c] = val[0];
			moveNum[c] = Integer.parseInt(val[1]);
			c++;
		}

		// Task A:
		int fwd = 0;
		int dph = 0;
		c = 0;
		for (String s : moveN) {
			if (s.equals("forward")) {
				fwd += moveNum[c];

			} else if (s.equals("up")) {
				dph -= moveNum[c];

			} else if (s.equals("down")) {
				dph += moveNum[c];
			}
			c++;
		}
		System.out.println("Task A:");
		System.out.println(fwd * dph);
		// Task B:

		fwd = 0;
		dph = 0;
		int aim = 0;
		c = 0;
		for (String s : moveN) {
			if (s.equals("forward")) {
				fwd += moveNum[c];
				dph += (aim * moveNum[c]);

			} else if (s.equals("up")) {
				aim -= moveNum[c];

			} else if (s.equals("down")) {
				aim += moveNum[c];
			}
			c++;
		}
		System.out.println("Task B:");
		System.out.println(fwd * dph);

	}

}

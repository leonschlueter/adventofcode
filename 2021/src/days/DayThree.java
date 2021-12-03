/* Advent of Code 2021
 * Day: Three
 * Author: Leon Schlüter
 * 
 */
package days;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputReader;

public class DayThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader ir = new InputReader("dayThree.txt");
		ArrayList<String> in = ir.readStringList();
		// Part one:
		int[] gam = new int[12];
		for (int i = 0; i < 12; i++) {
			int c = 0;
			for (String s : in) {
				if (s.charAt(i) == '1') {
					c++;
				}
			}
			if (c > 500) {
				gam[i] = 1;
			} else {
				gam[i] = 0;
			}
		}
		int[] eps = new int[12];
		for (int i = 0; i < eps.length; i++) {
			if (gam[i] == 1) {
				eps[i] = 0;
			} else {
				eps[i] = 1;
			}
		}
		System.out.println(findValueOf(gam) * findValueOf(eps));

		// Part two:
		ArrayList<String> cOTwo = new ArrayList<String>(in);

		System.out.println(in.size());
		String oxyV = "";
		String cOO = "";
		for (int i = 0; i < 12; i++) {
			int c = 0;
			for (String s : in) {
				if (s.charAt(i) == '1') {
					c++;
				}
			}
			ArrayList<String> tr = new ArrayList<String>();
			boolean one = c >= in.size() / 2;
			for (String s : in) {
				if (one && s.charAt(i) == '0') {
					tr.add(s);
				} else if (!one && s.charAt(i) == '1') {
					tr.add(s);
				}
			}
			in.removeAll(tr);
			if (in.size() == 1) {
				oxyV = in.get(0);
				System.out.println(oxyV);
			}
			System.out.println(in.size());
		}

		for (int i = 0; i < 12; i++) {
			int c = 0;
			for (String s : cOTwo) {
				if (s.charAt(i) == '1') {
					c++;
				}
			}
			ArrayList<String> tr = new ArrayList<String>();
			boolean one = c >= cOTwo.size() / 2;
			for (String s : cOTwo) {
				if (one && s.charAt(i) == '1') {
					tr.add(s);
				} else if (!one && s.charAt(i) == '0') {
					tr.add(s);
				}
			}
			cOTwo.removeAll(tr);
			if (cOTwo.size() == 1) {
				cOO = cOTwo.get(0);
				System.out.println(cOO);
			}
			System.out.println(cOTwo.size());
		}
		
		System.out.println(findValueOf(getArr(cOO))*findValueOf(getArr(oxyV)));
		
		
		

	}
	public static int[] getArr(String s) {
		int[] res = new int[12];
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i)== '1') {
				res[i] = 1;
			} else {
				res[i] = 0;
			}
		}
		return res;
	}
	public static int findValueOf(int[] b) {
		int res = 0;
		int dig = 11;
		for (int i = 0; i < b.length; i++) {

			res += b[i] * (int) Math.pow(2, dig);
			dig--;
		}
		return res;
	}
}

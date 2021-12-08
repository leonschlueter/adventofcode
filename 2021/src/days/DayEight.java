package days;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputReader;

public class DayEight {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayEight.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<String[]> arr = ir.giveEight();
		// Task A:
		int c = 0;
		for (String[] list : arr) {
			for (int i = 10; i < list.length; i++) {
				if (list[i].length() == 2 || list[i].length() == 4 || list[i].length() == 3 || list[i].length() == 7) {
					c++;
				}
			}
		}
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + c);
		beginTime = System.currentTimeMillis();
		// Task B:

		for (String[] list : arr) {
			String[] interpretations = new String[10];
			String[] codes = new String[7];
			int[][] table = new int[10][7];
			interpretations = findObvious(list);
			
			table = convertObviousToBytes(table, interpretations[1], 1);
			table = convertObviousToBytes(table, interpretations[4], 4);
			table = convertObviousToBytes(table, interpretations[7], 7);
			table = convertObviousToBytes(table, interpretations[8], 8);
			
			
			System.out.println("==================");
			int a = giveA(table[1],table[7]);
			for(int i = 0; i<10; i++) {
				if(i!=1 && i!=4 && i!=7 && i!=8)
				table[i][a] = 1;
			}
			int d = giveD(table[1], table[4]);
			System.out.println("==================");
			
		}
		
		System.out.println();
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");

	}


	private static int[][] convertObviousToBytes(int[][] table, String s,int num) {
		// TODO Auto-generated method stub
		char[] cA = s.toCharArray();
		for (char c : cA) {
			table[num][c - 'a'] = 1; 
		}
		System.out.println(Arrays.toString(table[num]));
		return table;
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
			if(list[i].length() == 3) {
				return list[i];
			}
		}
		return null;
	}

	private static String findFour(String[] list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.length; i++) {
			if(list[i].length() == 4) {
				return list[i];
			}
		}
		return null;
	}

	private static String findOne(String[] list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.length; i++) {
			if(list[i].length() == 2) {
				return list[i];
			}
		}
		return null;
	}
	private static int giveA(int[] two, int[] seven) {
		int[] arr = new int[7];
		for (int i = 0; i < arr.length; i++) {
			if(two[i] == 0 && seven[i]==1) {
				arr[i] = 1;
				System.out.println(Arrays.toString(arr));
				return i;
			}
		}
		
		return 0;
	}
	private static int giveD(int[] two, int[] seven) {
		int[] arr = new int[7];
		for (int i = 0; i < arr.length; i++) {
			if(two[i] == 1 && seven[i]==0) {
				arr[i] = 1;
				System.out.println(Arrays.toString(arr));
				return i;
			}
		}
		System.out.println("rip");
		return 0;
	}
}

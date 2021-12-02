package days;

import java.util.ArrayList;

import util.InputReader;

public class TemplateDay {

	public static void main(String[] args) {
		//Read input and return array
		InputReader ir = new InputReader("dayTwo.txt");
		ArrayList<Integer> in = ir.readIntegerList();
		
		
		//Task A:
		for (Integer i : in) {
			System.out.println(i);
		}
		
		//Task B:

	}

}

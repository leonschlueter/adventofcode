package days;
import util.InputReader;
import java.util.*;
public class DayOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader ir = new InputReader("dayOne.txt");
		ArrayList<Integer> in = ir.readIntegerList();
		
		for(Integer i : in) {
			System.out.println(i);
		}
		
	}	

}

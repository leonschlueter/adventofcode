package days;

import util.InputReader;
import util.Literal;

public class DaySixteen {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("selfTests.txt");
		String bin = ir.getBinVal();
		System.out.println(bin);
		long beginTime = System.currentTimeMillis();
		// Task A:
		Literal test = new Literal(bin);
		test.printPacket();
		
		
		
		
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println();
		beginTime = System.currentTimeMillis();
		// Task B:

		System.out.println();
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

}

package days;

import util.InputReader;
import util.Operator;
import util.Packet;

public class DaySixteen {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("daySixteen.txt");
		String bin = ir.getBinVal();
		long beginTime = System.currentTimeMillis();
		// Task A:
		Packet a = new Operator(bin, 0);	
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: "+a.versionSum);
		beginTime = System.currentTimeMillis();
		// Task B:

		System.out.println("Task B: "+ a.value);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

}

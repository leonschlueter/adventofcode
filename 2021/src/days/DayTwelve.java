package days;

import java.util.ArrayList;

import util.Cave;
import util.InputReader;

public class DayTwelve {
	private static ArrayList<ArrayList<String>> arr;

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayTwelve.txt");
		arr = ir.splitString();
		long beginTime = System.currentTimeMillis();
		Cave[] system = new Cave[arr.size()];
		Cave s = new Cave("xD");
		for (int i = 0; i < arr.size(); i++) {
			system[i] = new Cave(arr.get(i).get(0));
		}
		for (int i = 0; i < system.length; i++) {
			system[i].addNeighbors(arr.get(i), system);
			if (system[i].name.equals("start")) {
				s = system[i];
			}
		}
		// Task A:
		s.visited = true;
	
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: "+DFS(s, 0));
		beginTime = System.currentTimeMillis();
		// Task B:
		s.visitCount = 2;
		System.out.println("Task B: "+DFSB(s, 0, false));
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static int DFS(Cave cave, int c) {
		cave.visited = true;
		Cave[] neighbors = cave.neighbors;
		if (cave.name.equals("end")) {
			cave.visited = false;
			c++;
			return c;
		}
		int b = 0;
		for (int i = 0; i < neighbors.length; i++) {
			Cave n = neighbors[i];

			if (n.isBig || (!n.isBig && !n.visited)) {
				b += DFS(neighbors[i], c);
			}

		}
		cave.visited = false;
		return c + b;
	}

	private static int DFSB(Cave cave, int c, boolean twoUsed) {
		cave.visitCount++;
		if (cave.visitCount == 2 && !cave.isBig) {
			twoUsed = true;
		}

		Cave[] neighbors = cave.neighbors;
		if (cave.name.equals("end")) {
			cave.visitCount = 0;
			c++;
			return c;
		}
		int b = 0;
		for (int i = 0; i < neighbors.length; i++) {
			Cave n = neighbors[i];
			if (n.isBig || (!n.isBig && (n.visitCount == 0 || (n.visitCount == 1 && !twoUsed)) )) {
				
				b += DFSB(n, c, twoUsed);

			}

		}
		cave.visitCount--;
		return c + b;
	}
}

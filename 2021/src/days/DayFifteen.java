package days;

import java.util.ArrayList;
import java.util.PriorityQueue;

import util.InputReader;
import util.Node;

public class DayFifteen {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayFifteen.txt");
		long beginTime = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> arr = ir.give2DArrayList();
		int resA = dijkstra(arr);
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + resA);

		beginTime = System.currentTimeMillis();
		// Task B:

		ArrayList<ArrayList<Integer>> newMap = createCopy(arr, 0);
		ArrayList<ArrayList<Integer>> original = createCopy(newMap, 0);
		for (int i = 0; i < 4; i++) {
			ArrayList<ArrayList<Integer>> a = createCopy(original, i + 1);
			for (ArrayList<Integer> l : a) {
				newMap.add(l);
			}
		}
		ArrayList<ArrayList<Integer>> column = createCopy(newMap, 0);
		for (int i = 0; i < 4; i++) {
			ArrayList<ArrayList<Integer>> a = createCopy(column, i + 1);
			for (int j = 0; j < a.size(); j++) {
				newMap.get(j).addAll(a.get(j));
			}
		}

		int resB = dijkstra(newMap);
		System.out.println("Task B: " + resB);
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static int dijkstra(ArrayList<ArrayList<Integer>> map) {
		ArrayList<Node> list = new ArrayList<Node>();
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		Node[][] nodes = new Node[map.size()][map.get(0).size()];
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				nodes[i][j] = new Node(map.get(i).get(j));
				list.add(nodes[i][j]);

			}
		}
		Node s = nodes[0][0];
		s.distance = 0;
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				nodes[i][j].addNeighbors(nodes, i, j);
				q.add(nodes[i][j]);
			}
		}
		// Task A:

		while (q.size() > 0) {
			Node u = q.poll();
			for (Node v : u.neighbors) {
				int alt = u.distance + v.cost;
				if (alt < v.distance) {
					q.remove(v);
					v.distance = alt;
					v.previous = u;
					q.add(v);
				}

			}
		}

		return nodes[nodes.length - 1][nodes[0].length - 1].distance;
	}

	private static Node findSmallestDistance(ArrayList<Node> q) {
		Node min = new Node(0);
		for (Node n : q) {
			if (n.distance < min.distance) {
				min = n;
			}
		}
		return min;
	}

	private static ArrayList<ArrayList<Integer>> createCopy(ArrayList<ArrayList<Integer>> old, int add) {
		ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> a : old) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i : a) {
				if (i + add > 9) {
					l.add(i + add - 9);
				} else {
					l.add(i + add);
				}
			}
			n.add(l);
		}
		return n;
	}

	private static void printMap(ArrayList<ArrayList<Integer>> map) {
		for (ArrayList<Integer> a : map) {

			for (int i : a) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}

package days;

import java.util.ArrayList;
import util.*;

public class DayFive {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayFive.txt");
		ArrayList<Line> lines = ir.createLineArray();
		// Task A:
		int[][] map = drawLines(lines, false);
		int res = countMultiple(map);
		System.out.println("Result for Task A: " + res);
		// Task B:
		map = drawLines(lines, true);
		res = countMultiple(map);
		System.out.println("Result for Task B: " + res);
	}

	private static int[][] drawLines(ArrayList<Line> lines, boolean taskB) {
		int[][] map = new int[1000][1000];
		for (Line l : lines) {
			switch (l.mode) {
			case 1:
				map = drawVertical(l, map);
				break;
			case 2:
				map = drawHorizontal(l, map);
				break;
			case 3:
				if (taskB)
					map = drawDiagonal(l, map);
				break;
			}
		}
		return map;
	}

	private static int countMultiple(int[][] map) {
		int c = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > 1) {
					c++;
				}
			}
		}
		return c;
	}

	private static int[][] drawDiagonal(Line l, int[][] map) {
		int yDiff = l.end.y - l.start.y;
		boolean up = yDiff > 0;
		yDiff = Math.abs(yDiff);
		if (up) {

			for (int i = 0; i <= yDiff; i++) {
				map[l.start.y + i][l.start.x + i] += 1;
			}
		} else {

			for (int i = 0; i <= yDiff; i++) {
				map[l.start.y - i][l.start.x + i] += 1;
			}
		}
		return map;
	}

	private static int[][] drawVertical(Line l, int[][] map) {
		boolean up = l.start.y < l.end.y;
		int yDiff = Math.abs(l.end.y - l.start.y);
		if (up) {
			for (int i = l.start.y; i <= l.end.y; i++) {
				map[i][l.start.x] += 1;
			}
		} else {
			for (int i = 0; i <= yDiff; i++) {
				map[l.end.y + i][l.start.x] += 1;
			}
		}
		return map;
	}

	private static int[][] drawHorizontal(Line l, int[][] map) {
		for (int i = l.start.x; i <= l.end.x; i++) {
			map[l.start.y][i] += 1;
		}
		return map;
	}
}

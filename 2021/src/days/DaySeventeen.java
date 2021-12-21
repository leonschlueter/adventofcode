package days;

import java.util.Arrays;

import util.InputReader;

public class DaySeventeen {
	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("daySeventeen.txt");
		long beginTime = System.currentTimeMillis();
		int[][] area = ir.getSeventeen();
		// Task A:
		int max = findMaxY(area);
		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("TaskA: " + max);
		beginTime = System.currentTimeMillis();
		// Task B:

		System.out.println("Task B: " + findAmtOfPairs(area));
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static int findMaxY(int[][] area) {
		int ans = 0;
		int xStart = area[0][0];
		int xEnd = area[1][0];
		int yStart = area[0][1];
		int yEnd = area[1][1];

		for (int x = 0; x <= xEnd; x++) {
			for (int y = yStart; y < -(yStart); y++) {
				int vx = x;
				int vy = y;
				int cX = 0;
				int cY = 0;
				while (vy >= 0 || cY >= yStart) {

					if (xStart <= cX && cX <= xEnd && yStart <= cY && cY <= yEnd) {
						ans = Math.max(ans, sum(y));
					}
					cX += vx;
					cY += vy;
					vx = Math.max(0, vx - 1);
					vy--;
				}

			}
		}

		return ans;
	}

	private static int findAmtOfPairs(int[][] area) {
		int ans = 0;
		int xStart = area[0][0];
		int xEnd = area[1][0];
		int yStart = area[0][1];
		int yEnd = area[1][1];

		for (int x = 0; x <= xEnd; x++) {
			for (int y = yStart; y < -(yStart); y++) {
				boolean c = false;
				int vx = x;
				int vy = y;
				int cX = 0;
				int cY = 0;
				while ((vy >= 0 || cY >= yStart) && !c) {

					if (xStart <= cX && cX <= xEnd && yStart <= cY && cY <= yEnd) {
						ans++;
						c = true;
					}

					cX += vx;
					cY += vy;
					vx = Math.max(0, vx - 1);
					vy--;
				}

			}
		}

		return ans;
	}

	private static int sum(int n) {
		int s = 0;
		for (int i = 1; i <= n; i++) {
			s += i;
		}
		return s;
	}
}

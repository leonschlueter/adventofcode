package util;

public class Line {
	public Point start;
	public Point end;
	public int mode;

	public Line(Point p1, Point p2) {
		this.start = p1;
		this.end = p2;
		this.mode = findMode();
	}

	private int findMode() {
		if (start.x == end.x) {
			return 1;
		} else if (start.y == end.y) {
			return 2;
		} else if (Math.abs(start.x - end.x) == Math.abs(start.y - end.y)) {
			return 3;
		}
		return 0;
	}
}

package util;

public class Node implements Comparable<Node> {
	public int cost;
	public Node[] neighbors;
	public int distance;
	public Node previous;

	public Node(int cost) {
		this.cost = cost;
		this.distance = Integer.MAX_VALUE;
	}

	public void addNeighbors(Node[][] nodes, int i, int j) {
		if (i == 0) {
			if (j == nodes[0].length - 1) {
				this.neighbors = new Node[2];
				neighbors[0] = nodes[i][j - 1];
				neighbors[1] = nodes[i + 1][j];
			} else if (j == 0) {
				this.neighbors = new Node[2];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i + 1][j];
			} else {
				this.neighbors = new Node[3];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i + 1][j];
				neighbors[2] = nodes[i][j - 1];
			}
		} else if (i == nodes.length - 1) {
			if (j == nodes[0].length - 1) {
				this.neighbors = new Node[2];
				neighbors[0] = nodes[i][j - 1];
				neighbors[1] = nodes[i - 1][j];
			} else if (j == 0) {
				this.neighbors = new Node[2];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i - 1][j];
			} else {
				this.neighbors = new Node[3];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i - 1][j];
				neighbors[2] = nodes[i][j - 1];
			}
		} else {
			if (j == nodes[0].length - 1) {
				this.neighbors = new Node[3];
				neighbors[0] = nodes[i][j - 1];
				neighbors[1] = nodes[i - 1][j];
				neighbors[2] = nodes[i + 1][j];
			} else if (j == 0) {
				this.neighbors = new Node[3];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i - 1][j];
				neighbors[2] = nodes[i + 1][j];
			} else {
				this.neighbors = new Node[4];
				neighbors[0] = nodes[i][j + 1];
				neighbors[1] = nodes[i - 1][j];
				neighbors[2] = nodes[i][j - 1];
				neighbors[3] = nodes[i + 1][j];
			}

		}

	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub

		return Long.compare(this.distance, o.distance);
	}
}

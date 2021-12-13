package util;

import java.util.ArrayList;

public class Cave {
	public String name;
	public Cave[] neighbors;
	public boolean isBig;
	public boolean visited;
	public int visitCount;
	public Cave(String name) {
		this.name = name;
		if (Character.isUpperCase(name.charAt(0))) {
			this.isBig = true;
		} else {
			this.isBig = false;
		}
		this.visited = false;
		this.visitCount = 0;
	}

	public void addNeighbors(ArrayList<String> list, Cave[] system) {
		this.neighbors = new Cave[list.size() - 1];
		int j = 0;
		for (String n : list) {
			if (!n.equals(this.name)) {
				for (int i = 0; i < system.length; i++) {
					if (system[i].name.equals(n)) {
						neighbors[j] = system[i];
						j++;
					}
				}
			}
		}
	}

	public void printNeighbors() {
		System.out.print(this.name + ": ");
		for (int i = 0; i < neighbors.length; i++) {
			System.out.print(neighbors[i].name + " ");
		}
		System.out.println();
	}
}

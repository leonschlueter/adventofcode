package days;

import java.util.ArrayList;

import util.InputReader;

public class DayFour {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayFour01.txt");
		ArrayList<Integer> in = ir.splitIntegerList(',');
		InputReader cd = new InputReader("dayFour02.txt");
		ArrayList<int[][][]> cards = cd.createThreeDMatrix();

		// Task A: Find the card with first bingo
		int[][][] winner = findWinner(cards, in);
		System.out.println("<==============>");
		System.out.println("Task A:");
		System.out.println("Sum of winner: " + (getSum(winner) * findWinnerNum(resetCard(winner), in)));

		// Task B:
		for (int i = 0; i < in.size() - 1; i++) {
			int[][][] win = findWinner(cards, in);
			cards.remove(win);
		}
		System.out.println("<==============>");
		System.out.println("Task B:");
		winner = findWinner(cards, in);
		System.out.println("Sum of loser: " + (getSum(winner) * findWinnerNum(resetCard(winner), in)));
		System.out.println("<==============>");
	}

	public static int[][][] findWinner(ArrayList<int[][][]> cards, ArrayList<Integer> in) {
		for (int num : in) {
			for (int[][][] card : cards) {
				for (int i = 0; i < card.length; i++) {
					for (int j = 0; j < card.length; j++) {
						if (num == card[i][j][0]) {
							card[i][j][1] = 1;
						}
					}
				}
				if (checkForBingo(card)) {
					return card;
				}
			}
		}
		return null;
	}

	public static int findWinnerNum(int[][][] card, ArrayList<Integer> in) {
		for (int num : in) {
			for (int i = 0; i < card.length; i++) {
				for (int j = 0; j < card.length; j++) {
					if (num == card[i][j][0]) {
						card[i][j][1] = 1;
					}
				}
			}
			if (checkForBingo(card)) {
				return num;
			}

		}
		return -1;
	}

	public static boolean checkForBingo(int[][][] card) {
		for (int i = 0; i < card.length; i++) {
			int row = 0;
			int col = 0;
			for (int j = 0; j < card.length; j++) {
				row += card[i][j][1];
				col += card[j][i][1];
			}
			if (row == 5 || col == 5) {
				return true;
			}
		}
		return false;
	}

	public static int getSum(int[][][] winner) {
		int sum = 0;
		for (int i = 0; i < winner.length; i++) {
			for (int j = 0; j < winner.length; j++) {
				if (winner[i][j][1] == 0) {
					sum += winner[i][j][0];
				}
			}
		}
		return sum;
	}

// Debug methods:
	public static int[][][] resetCard(int[][][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j][1] = 0;
			}
		}
		return arr;
	}

	public static void printCard(int[][][] card, int num) {
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card.length; j++) {
				System.out.print(card[i][j][num] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

	public static void printCards(ArrayList<int[][][]> cards) {
		for (int[][][] card : cards) {
			printCard(card, 0);
			printCard(card, 1);
		}
	}
}

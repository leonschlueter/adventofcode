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
		System.out.println(cards.size());
		System.out.println(in.size());

		// Task A: Find the card with first bingo
		int[][][] winner = findWinner(cards, in);
		for (int i = 0; i < winner.length; i++) {
			for (int j = 0; j < winner.length; j++) {
				System.out.print(winner[i][j][0] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < winner.length; i++) {
			for (int j = 0; j < winner.length; j++) {
				System.out.print(winner[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println("<==============>");
		System.out.println("Sum of winner: " + (getSum(winner) * 91));
		System.out.println("<==============>");
		// Task B:
		for (int i = 0; i < in.size() - 1; i++) {
			int[][][] win = findWinner(cards, in);
			cards.remove(win);
		}
		System.out.println("<==============>");
		winner = findWinner(cards, in);
		printCards(cards);

		System.out.println("Sum of loser: " + (getSum(winner) * 97));
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
					printCard(card, 0);
					return card;
				}

			}
		}
		return null;
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

	public static void printCards(ArrayList<int[][][]> cards) {
		for (int[][][] card : cards) {
			printCard(card, 0);
			printCard(card, 1);
		}
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
}

package gracefulsoul.problems;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

	// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/submissions/1064482780/
	public static void main(String[] args) {
		RemoveColoredPiecesIfBothNeighborsAreTheSameColor test = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor();
		System.out.println(test.winnerOfGame("AAABABB"));
		System.out.println(test.winnerOfGame("AA"));
		System.out.println(test.winnerOfGame("ABBBBBBBAAA"));
	}

	public boolean winnerOfGame(String colors) {
		char[] charArray = colors.toCharArray();
		int sum = 0;
		for (int i = 1; i < charArray.length - 1; i++) {
			if (charArray[i] == charArray[i - 1] && charArray[i] == charArray[i + 1]) {
				if (charArray[i] == 'A') {
					sum++;
				} else {
					sum--;
				}
			}
		}
		return sum > 0;
	}

}

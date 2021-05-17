package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	// https://leetcode.com/submissions/detail/494387435/
	public static void main(String[] args) {
		ValidSudoku test = new ValidSudoku();
		System.out.println(test.isValidSudoku(new char[][] {
				new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		}));
		System.out.println(test.isValidSudoku(new char[][] {
				new char[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		}));

	}

	public boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (!set.add(this.appendString(i, board[i][j])) ||
						!set.add(this.appendString(board[i][j], j)) ||
						!set.add(this.appendString(i / 3, j / 3, board[i][j]))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private String appendString(int... ints) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < ints.length; idx++) {
			sb.append(ints[idx]);
			if (idx < ints.length - 1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}

}

package gracefulsoul.problems;

public class WordSearch {

	// https://leetcode.com/submissions/detail/514222856/
	public static void main(String[] args) {
		WordSearch test = new WordSearch();
		System.out.println(test.exist(new char[][] {
			new char[] {'A','B','C','E'},
			new char[] {'S','F','C','S'},
			new char[] {'A','D','E','E'}
		}, "ABCCED"));
		System.out.println(test.exist(new char[][] {
			new char[] {'A','B','C','E'},
			new char[] {'S','F','C','S'},
			new char[] {'A','D','E','E'}
		}, "SEE"));
		System.out.println(test.exist(new char[][] {
			new char[] {'A','B','C','E'},
			new char[] {'S','F','C','S'},
			new char[] {'A','D','E','E'}
		}, "ABCB"));
	}

	public boolean exist(char[][] board, String word) {
		char[] charArray = word.toCharArray();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (this.check(board, row, col, charArray, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean check(char[][] board, int row, int col, char[] charArray, int idx) {
		if (idx == charArray.length) {
			return true;
		} else if (row < 0 || col < 0 || row == board.length || col == board[row].length
				|| board[row][col] != charArray[idx]) {
			return false;
		} else {
			board[row][col] = 0;
			boolean exist = this.check(board, row, col + 1, charArray, idx + 1)
					|| this.check(board, row + 1, col, charArray, idx + 1)
					|| this.check(board, row, col - 1, charArray, idx + 1)
					|| this.check(board, row - 1, col, charArray, idx + 1);
			board[row][col] = charArray[idx];
			return exist;
		}
	}

}

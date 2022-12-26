package gracefulsoul.problems;

public class TransformToChessboard {

	// https://leetcode.com/problems/transform-to-chessboard/submissions/865543485/
	public static void main(String[] args) {
		TransformToChessboard test = new TransformToChessboard();
		System.out.println(test.movesToChessboard(new int[][] {
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 1, 0, 0, 1 },
			{ 1, 0, 0, 1 }
		}));
		System.out.println(test.movesToChessboard(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.movesToChessboard(new int[][] {
			{ 1, 0 },
			{ 1, 0 }
		}));
	}

	public int movesToChessboard(int[][] board) {
		int length = board.length;
		int rowSum = 0;
		int colSum = 0;
		int rowSwap = 0;
		int colSwap = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
					return -1;
				}
			}
		}
		for (int idx = 0; idx < length; idx++) {
			rowSum += board[0][idx];
			colSum += board[idx][0];
			if (board[idx][0] == idx % 2) {
				rowSwap++;
			}
			if (board[0][idx] == idx % 2) {
				colSwap++;
			}
		}
		if (rowSum != length / 2 && rowSum != (length + 1) / 2) {
			return -1;
		}
		if (colSum != length / 2 && colSum != (length + 1) / 2) {
			return -1;
		}
		if (length % 2 == 1) {
			if (colSwap % 2 == 1) {
				colSwap = length - colSwap;
			}
			if (rowSwap % 2 == 1) {
				rowSwap = length - rowSwap;
			}
		} else {
			colSwap = Math.min(length - colSwap, colSwap);
			rowSwap = Math.min(length - rowSwap, rowSwap);
		}
		return (colSwap + rowSwap) / 2;
	}

}

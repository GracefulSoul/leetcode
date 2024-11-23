package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class RotatingTheBox {

	// https://leetcode.com/problems/rotating-the-box/submissions/1460398717/
	public static void main(String[] args) {
		RotatingTheBox test = new RotatingTheBox();
		PrintUtil.print(test.rotateTheBox(new char[][] {
			{ '#', '.', '#' }
		}));
		PrintUtil.print(test.rotateTheBox(new char[][] {
			{ '#', '.', '*', '.' },
			{ '#', '#', '*', '.' }
		}));
		PrintUtil.print(test.rotateTheBox(new char[][] {
			{ '#', '#', '*', '.', '*', '.' },
			{ '#', '#', '#', '*', '.', '.' },
			{ '#', '#', '#', '.', '#', '.' }
		}));
	}

	public char[][] rotateTheBox(char[][] box) {
		int row = box.length;
		int col = box[0].length;
		char[][] result = new char[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = col - 1, k = col - 1; j >= 0; j--) {
				result[j][row - i - 1] = '.';
				if (box[i][j] != '.') {
					if (box[i][j] == '*') {
						k = j;
					}
					result[k--][row - i - 1] = box[i][j];
				}
			}
		}
		return result;
	}

}

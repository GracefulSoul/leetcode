package gracefulsoul.problems;

public class AlphabetBoardPath {

	// https://leetcode.com/problems/alphabet-board-path/submissions/1298562896/
	public static void main(String[] args) {
		AlphabetBoardPath test = new AlphabetBoardPath();
		System.out.println(test.alphabetBoardPath("leet"));
		System.out.println(test.alphabetBoardPath("code"));
	}

	public String alphabetBoardPath(String target) {
		int x = 0;
		int y = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : target.toCharArray()) {
			int x1 = (c - 'a') / 5;
			int y1 = (c - 'a') % 5;
			while (x1 < x) {
				x--;
				sb.append('U');
			}
			while (y1 > y) {
				y++;
				sb.append('R');
			}
			while (y1 < y) {
				y--;
				sb.append('L');
			}
			while (x1 > x) {
				x++;
				sb.append('D');
			}
			sb.append('!');
		}
		return sb.toString();
	}

}

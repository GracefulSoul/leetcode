package gracefulsoul.problems;

public class CheckIfItIsAStraightLine {

	// https://leetcode.com/problems/check-if-it-is-a-straight-line/submissions/964275575/
	public static void main(String[] args) {
		CheckIfItIsAStraightLine test = new CheckIfItIsAStraightLine();
		System.out.println(test.checkStraightLine(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 4, 5 },
			{ 5, 6 },
			{ 6, 7 }
		}));
		System.out.println(test.checkStraightLine(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 4 },
			{ 4, 5 },
			{ 5, 6 },
			{ 7, 7 }
		}));
	}

	public boolean checkStraightLine(int[][] coordinates) {
		int x = coordinates[1][0];
		int y = coordinates[1][1];
		int dx = x - coordinates[0][0];
		int dy = y - coordinates[0][1];
		for (int[] coordinate : coordinates) {
			if (dx * (coordinate[1] - y) != dy * (coordinate[0] - x)) {
				return false;
			}
		}
		return true;
	}

}

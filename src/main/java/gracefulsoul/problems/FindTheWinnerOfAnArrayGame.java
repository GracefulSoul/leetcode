package gracefulsoul.problems;

public class FindTheWinnerOfAnArrayGame {

	// https://leetcode.com/problems/find-the-winner-of-an-array-game/submissions/1091875432/
	public static void main(String[] args) {
		FindTheWinnerOfAnArrayGame test = new FindTheWinnerOfAnArrayGame();
		System.out.println(test.getWinner(new int[] { 2, 1, 3, 5, 4, 6, 7 }, 2));
		System.out.println(test.getWinner(new int[] { 3, 2, 1 }, 10));
	}

	public int getWinner(int[] arr, int k) {
		int result = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (result < arr[i]) {
				result = arr[i];
				count = 0;
			}
			if (++count == k) {
				break;
			}
		}
		return result;
	}

}

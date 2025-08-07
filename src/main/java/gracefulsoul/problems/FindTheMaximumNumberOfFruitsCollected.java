package gracefulsoul.problems;

public class FindTheMaximumNumberOfFruitsCollected {

	// https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/submissions/1726700101/
	public static void main(String[] args) {
		FindTheMaximumNumberOfFruitsCollected test = new FindTheMaximumNumberOfFruitsCollected();
		System.out.println(test.maxCollectedFruits(new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 8, 7 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		}));
		System.out.println(test.maxCollectedFruits(new int[][] {
			{ 1, 1 },
			{ 1, 1 }
		}));
	}

	public int maxCollectedFruits(int[][] fruits) {
		int length = fruits.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i < j && j < length - 1 - i) {
					fruits[i][j] = 0;
				}
				if (j < i && i < length - 1 - j) {
					fruits[i][j] = 0;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			result += fruits[i][i];
		}
		for (int i = 1; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				fruits[i][j] += Math.max(fruits[i - 1][j - 1],
						Math.max(fruits[i - 1][j], (j + 1 < length) ? fruits[i - 1][j + 1] : 0));
			}
		}
		for (int j = 1; j < length; j++) {
			for (int i = j + 1; i < length; i++) {
				fruits[i][j] += Math.max(fruits[i - 1][j - 1],
						Math.max(fruits[i][j - 1], (i + 1 < length) ? fruits[i + 1][j - 1] : 0));
			}
		}
		return result + fruits[length - 1][length - 2] + fruits[length - 2][length - 1];
	}

}

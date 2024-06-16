package gracefulsoul.problems;

public class NumberOfEquivalentDominoPairs {

	// https://leetcode.com/problems/number-of-equivalent-domino-pairs/submissions/1289707491/
	public static void main(String[] args) {
		NumberOfEquivalentDominoPairs test = new NumberOfEquivalentDominoPairs();
		System.out.println(test.numEquivDominoPairs(new int[][] {
			{ 1, 2 },
			{ 2, 1 },
			{ 3, 4 },
			{ 5, 6 }
		}));
		System.out.println(test.numEquivDominoPairs(new int[][] {
			{ 1, 2 },
			{ 1, 2 },
			{ 1, 1 },
			{ 1, 2 },
			{ 2, 2 }
		}));
	}

	public int numEquivDominoPairs(int[][] dominoes) {
		int[] count = new int[100];
		int result = 0;
		for (int[] domino : dominoes) {
			if (domino[0] < domino[1]) {
				result += count[domino[0] * 10 + domino[1]]++;
			} else {
				result += count[domino[1] * 10 + domino[0]]++;
			}
		}
		return result;
	}

}

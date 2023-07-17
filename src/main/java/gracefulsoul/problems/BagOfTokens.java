package gracefulsoul.problems;

import java.util.Arrays;

public class BagOfTokens {

	// https://leetcode.com/problems/bag-of-tokens/submissions/996562855/
	public static void main(String[] args) {
		BagOfTokens test = new BagOfTokens();
		System.out.println(test.bagOfTokensScore(new int[] { 100 }, 50));
		System.out.println(test.bagOfTokensScore(new int[] { 100, 200 }, 150));
		System.out.println(test.bagOfTokensScore(new int[] { 100, 200, 300, 400 }, 200));
	}

	public int bagOfTokensScore(int[] tokens, int power) {
		Arrays.sort(tokens);
		int result = 0;
		int points = 0;
		int left = 0;
		int right = tokens.length - 1;
		while (left <= right) {
			if (tokens[left] <= power) {
				power -= tokens[left++];
				result = Math.max(result, ++points);
			} else if (points > 0) {
				points--;
				power += tokens[right--];
			} else {
				break;
			}
		}
		return result;
	}

}

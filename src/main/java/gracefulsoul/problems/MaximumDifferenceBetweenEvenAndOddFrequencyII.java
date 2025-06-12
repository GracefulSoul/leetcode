package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenAndOddFrequencyII {

	// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/submissions/1660777176/
	public static void main(String[] args) {
		MaximumDifferenceBetweenEvenAndOddFrequencyII test = new MaximumDifferenceBetweenEvenAndOddFrequencyII();
		System.out.println(test.maxDifference("12233", 4));
		System.out.println(test.maxDifference("1122211", 3));
		System.out.println(test.maxDifference("110", 3));
	}

	public int maxDifference(String s, int k) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int result = Integer.MIN_VALUE;
		for (int a = 0; a <= 4; a++) {
			for (int b = 0; b <= 4; b++) {
				if (a == b) {
					continue;
				}
				int[] sumA = new int[length + 1];
				int[] sumB = new int[length + 1];
				for (int i = 1; i <= length; ++i) {
					sumA[i] = sumA[i - 1] + (charArray[i - 1] - '0' == a ? 1 : 0);
					sumB[i] = sumB[i - 1] + (charArray[i - 1] - '0' == b ? 1 : 0);
				}
				int[][] best = new int[2][2];
				for (int i = 0; i < 2; i++) {
					Arrays.fill(best[i], Integer.MIN_VALUE);
				}
				int j = 0;
				for (int i = k; i <= length; i++) {
					while (i - j >= k && sumA[i] > sumA[j] && sumB[i] > sumB[j]) {
						int prevA = sumA[j] % 2;
						int prevB = sumB[j] % 2;
						best[prevA][prevB] = Math.max(best[prevA][prevB], sumB[j] - sumA[j]);
						j++;
					}
					int prevA = sumA[i] % 2;
					int prevB = sumB[i] % 2;
					if (best[1 - prevA][prevB] != Integer.MIN_VALUE) {
						result = Math.max(result, (sumA[i] - sumB[i]) + best[1 - prevA][prevB]);
					}
				}
			}
		}
		return result == Integer.MIN_VALUE ? -1 : result;
	}

}

package gracefulsoul.problems;

import java.util.Arrays;

public class PutMarblesInBags {

	// https://leetcode.com/problems/put-marbles-in-bags/submissions/1591866821/
	public static void main(String[] args) {
		PutMarblesInBags test = new PutMarblesInBags();
		System.out.println(test.putMarbles(new int[] { 1, 3, 5, 1 }, 2));
		System.out.println(test.putMarbles(new int[] { 1, 3 }, 2));
	}

	public long putMarbles(int[] weights, int k) {
		int length = weights.length;
		int[] sum = new int[length - 1];
		for (int i = 0; i < sum.length; i++) {
			sum[i] = weights[i] + weights[i + 1];
		}
		Arrays.sort(sum);
		long result = 0;
		for (int i = 0; i < k - 1; i++) {
			result += sum[length - 2 - i] - sum[i];
		}
		return result;
	}

}

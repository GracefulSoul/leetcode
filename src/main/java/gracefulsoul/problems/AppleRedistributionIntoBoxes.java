package gracefulsoul.problems;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

	// https://leetcode.com/problems/apple-redistribution-into-boxes/submissions/1863776323/
	public static void main(String[] args) {
		AppleRedistributionIntoBoxes test = new AppleRedistributionIntoBoxes();
		System.out.println(test.minimumBoxes(new int[] { 1, 3, 2 }, new int[] { 4, 3, 1, 5, 2 }));
		System.out.println(test.minimumBoxes(new int[] { 5, 5, 5 }, new int[] { 2, 4, 2, 7 }));
	}

	public int minimumBoxes(int[] apple, int[] capacity) {
		int sum = 0;
		for (int count : apple) {
			sum += count;
		}
		int result = 0;
		Arrays.sort(capacity);
		for (int i = capacity.length - 1; 0 <= i && 0 < sum; i--) {
			result++;
			sum -= capacity[i];
		}
		return result;
	}

}

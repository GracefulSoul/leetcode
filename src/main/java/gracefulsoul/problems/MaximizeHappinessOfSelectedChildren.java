package gracefulsoul.problems;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

	// https://leetcode.com/problems/maximize-happiness-of-selected-children/submissions/1253461931/
	public static void main(String[] args) {
		MaximizeHappinessOfSelectedChildren test = new MaximizeHappinessOfSelectedChildren();
		System.out.println(test.maximumHappinessSum(new int[] { 1, 2, 3 }, 2));
		System.out.println(test.maximumHappinessSum(new int[] { 1, 1, 1, 1 }, 2));
		System.out.println(test.maximumHappinessSum(new int[] { 2, 3, 4, 5 }, 1));
	}

	public long maximumHappinessSum(int[] happiness, int k) {
		Arrays.sort(happiness);
		long result = 0;
		int length = happiness.length;
		for (int i = length - 1, j = 0; i >= length - k; i--) {
			result += Math.max(0, happiness[i] - j++);
		}
		return result;
	}

}

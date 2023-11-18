package gracefulsoul.problems;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

	// https://leetcode.com/problems/frequency-of-the-most-frequent-element/submissions/1101293626/
	public static void main(String[] args) {
		FrequencyOfTheMostFrequentElement test = new FrequencyOfTheMostFrequentElement();
		System.out.println(test.maxFrequency(new int[] { 1, 2, 4 }, 5));
		System.out.println(test.maxFrequency(new int[] { 1, 4, 8, 13 }, 5));
		System.out.println(test.maxFrequency(new int[] { 3, 9, 6 }, 2));
	}

	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int result = 0;
		long sum = 0;
		for (int i = 0, j = 0; j < nums.length; j++) {
			sum += nums[j];
			while (nums[j] * (j - i + 1) > k + sum) {
				sum -= nums[i++];
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

}

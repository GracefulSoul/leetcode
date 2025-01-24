package gracefulsoul.problems;

public class MaximumEqualFrequency {

	// https://leetcode.com/problems/maximum-equal-frequency/submissions/1518517607/
	public static void main(String[] args) {
		MaximumEqualFrequency test = new MaximumEqualFrequency();
		System.out.println(test.maxEqualFreq(new int[] { 2, 2, 1, 1, 5, 3, 3, 5 }));
		System.out.println(test.maxEqualFreq(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5 }));
	}

	public int maxEqualFreq(int[] nums) {
		int[] counts = new int[100001];
		int[] frequencies = new int[100001];
		int length = nums.length;
		int result = 0;
		for (int i = 0; i < length; i++) {
			counts[nums[i]]++;
			int frequency = counts[nums[i]];
			frequencies[frequency]++;
			int count = frequencies[frequency] * frequency;
			if (count == i + 1 && i != length - 1) {
				result = Math.max(result, i + 2);
			} else if (count == i) {
				result = Math.max(result, i + 1);
			}
		}
		return result;
	}

}

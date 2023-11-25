package gracefulsoul.problems;

public class SumOfAbsoluteDifferencesInASortedArray {

	// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/submissions/1105812466/
	public static void main(String[] args) {
		SumOfAbsoluteDifferencesInASortedArray test = new SumOfAbsoluteDifferencesInASortedArray();
		System.out.println(test.getSumAbsoluteDifferences(new int[] { 2, 3, 5 }));
		System.out.println(test.getSumAbsoluteDifferences(new int[] { 1, 4, 6, 8, 10 }));
	}

	public int[] getSumAbsoluteDifferences(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		int[] sum = new int[length + 1];
		for (int i = 0; i < length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		for (int i = 0; i < length; i++) {
			result[i] = (i * nums[i]) - sum[i] + (sum[length] - sum[i] - ((length - i) * nums[i]));
		}
		return result;
	}

}

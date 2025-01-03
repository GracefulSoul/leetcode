package gracefulsoul.problems;

public class NumberOfWaysToSplitArray {

	// https://leetcode.com/problems/number-of-ways-to-split-array/submissions/1495755516/
	public static void main(String[] args) {
		NumberOfWaysToSplitArray test = new NumberOfWaysToSplitArray();
		System.out.println(test.waysToSplitArray(new int[] { 10, 4, -8, 7 }));
		System.out.println(test.waysToSplitArray(new int[] { 2, 3, 1, 0 }));
	}

	public int waysToSplitArray(int[] nums) {
		int length = nums.length;
		long left = 0;
		long right = 0;
		for (int num : nums) {
			right += num;
		}
		int result = 0;
		for (int i = 0; i < length - 1; i++) {
			left += nums[i];
			right -= nums[i];
			if (left >= right) {
				result++;
			}
		}
		return result;
	}

}

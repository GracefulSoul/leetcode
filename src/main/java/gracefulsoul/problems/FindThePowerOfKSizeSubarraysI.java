package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindThePowerOfKSizeSubarraysI {

	// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/submissions/1453939643/
	public static void main(String[] args) {
		FindThePowerOfKSizeSubarraysI test = new FindThePowerOfKSizeSubarraysI();
		PrintUtil.print(test.resultsArray(new int[] { 1, 2, 3, 4, 3, 2, 5 }, 3));
		PrintUtil.print(test.resultsArray(new int[] { 2, 2, 2, 2, 2 }, 4));
		PrintUtil.print(test.resultsArray(new int[] { 3, 2, 3, 2, 3, 2 }, 2));
	}

	public int[] resultsArray(int[] nums, int k) {
		int length = nums.length;
		int[] result = new int[length - k + 1];
		int sum = 0;
		for (int i = 0; i < k - 1; i++) {
			sum += nums[i];
		}
		int index = 0;
		for (int i = 0, j = k - 1; j < length; i++, j++, index++) {
			sum += nums[j];
			if ((k * (nums[i] + nums[i] + k - 1) / 2) == sum && nums[i] <= nums[j]) {
				result[index] = nums[j];
			} else {
				result[index] = -1;
			}
			sum -= nums[i];
		}
		return result;
	}

}

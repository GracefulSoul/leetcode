package gracefulsoul.problems;

public class ShortestSubarrayWithSumAtLeastK {

	// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/submissions/909453795/
	public static void main(String[] args) {
		ShortestSubarrayWithSumAtLeastK test = new ShortestSubarrayWithSumAtLeastK();
		System.out.println(test.shortestSubarray(new int[] { 1 }, 1));
		System.out.println(test.shortestSubarray(new int[] { 1, 2 }, 4));
		System.out.println(test.shortestSubarray(new int[] { 2, -1, 2 }, 3));
	}

	public int shortestSubarray(int[] nums, int k) {
		int length = nums.length;
		long[] sum = new long[length + 1];
		for (int i = 0; i < length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		int left = 0;
		int right = -1;
		int[] dp = new int[length + 1];
		int result = length + 1;
		for (int i = 0; i <= length; i++) {
			while (right - left + 1 > 0 && sum[i] - sum[dp[left]] >= k) {
				result = Math.min(result, i - dp[left]);
				left++;
			}
			while (right - left + 1 > 0 && sum[dp[right]] >= sum[i]) {
				right--;
			}
			dp[++right] = i;

		}
		return result == nums.length + 1 ? -1 : result;
	}

}

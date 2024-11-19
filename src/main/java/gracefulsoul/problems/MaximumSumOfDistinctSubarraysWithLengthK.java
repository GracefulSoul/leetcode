package gracefulsoul.problems;

public class MaximumSumOfDistinctSubarraysWithLengthK {

	// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/submissions/1457096839/
	public static void main(String[] args) {
		MaximumSumOfDistinctSubarraysWithLengthK test = new MaximumSumOfDistinctSubarraysWithLengthK();
		System.out.println(test.maximumSubarraySum(new int[] { 1, 5, 4, 2, 9, 9, 9 }, 3));
		System.out.println(test.maximumSubarraySum(new int[] { 4, 4, 4 }, 3));
	}

	public long maximumSubarraySum(int[] nums, int k) {
		boolean[] visited = new boolean[100001];
		long sum = 0L;
		long result = 0L;
		for (int i = 0, j = 0; j < nums.length; j++) {
			int num = nums[j];
			while (visited[num] || (j - i + 1 > k && i < j)) {
				sum -= nums[i];
				visited[nums[i++]] = false;
			}
			sum += num;
			if (j - i + 1 == k) {
				result = Math.max(result, sum);
			}
			visited[num] = true;
		}
		return result;
	}

}

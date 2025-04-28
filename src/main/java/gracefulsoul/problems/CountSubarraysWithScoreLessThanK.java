package gracefulsoul.problems;

public class CountSubarraysWithScoreLessThanK {

	// https://leetcode.com/problems/count-subarrays-with-score-less-than-k/submissions/1620118512/
	public static void main(String[] args) {
		CountSubarraysWithScoreLessThanK test = new CountSubarraysWithScoreLessThanK();
		System.out.println(test.countSubarrays(new int[] { 2, 1, 4, 3, 5 }, 10));
		System.out.println(test.countSubarrays(new int[] { 1, 1, 1 }, 5));
	}

	public long countSubarrays(int[] nums, long k) {
		long sum = 0;
		long result = 0;
		for (int i = 0, j = 0; j < nums.length; j++) {
			sum += nums[j];
			while (sum * (j - i + 1) >= k) {
				sum -= nums[i++];
			}
			result += j - i + 1;
		}
		return result;
	}

}

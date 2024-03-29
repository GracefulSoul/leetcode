package gracefulsoul.problems;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

	// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/submissions/1217183878/
	public static void main(String[] args) {
		CountSubarraysWhereMaxElementAppearsAtLeastKTimes test = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
		System.out.println(test.countSubarrays(new int[] { 1, 3, 2, 3, 3 }, 2));
		System.out.println(test.countSubarrays(new int[] { 1, 4, 2, 1 }, 3));
	}

	public long countSubarrays(int[] nums, int k) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		long result = 0;
		for (int i = 0, j = 0; j < nums.length; j++) {
			k -= nums[j] == max ? 1 : 0;
			while (k == 0) {
				k += nums[i++] == max ? 1 : 0;
			}
			result += i;
		}
		return result;
	}

}

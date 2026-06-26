package gracefulsoul.problems;

public class CountSubarraysWithMajorityElementII {

	// https://leetcode.com/problems/count-subarrays-with-majority-element-ii/submissions/2046939873/
	public static void main(String[] args) {
		CountSubarraysWithMajorityElementII test = new CountSubarraysWithMajorityElementII();
		System.out.println(test.countMajoritySubarrays(new int[] { 1, 2, 2, 3 }, 2));
		System.out.println(test.countMajoritySubarrays(new int[] { 1, 1, 1, 1 }, 1));
		System.out.println(test.countMajoritySubarrays(new int[] { 1, 2, 3 }, 4));
	}

	public long countMajoritySubarrays(int[] nums, int target) {
		int length = nums.length;
		long[] counts = new long[(length * 2) + 2];
		long[] sum = new long[(length * 2) + 2];
		int i = length + 1;
		long result = 0;
		counts[i] = sum[i] = 1;
		for (int num : nums) {
			i += (num == target ? 1 : -1);
			sum[i] = ++counts[i] + sum[i - 1];
			result += sum[i - 1];
		}
		return result;
	}

}

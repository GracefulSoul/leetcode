package gracefulsoul.problems;

public class NumberOfSubarraysWithBoundedMaximum {

	// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/submissions/872962189/
	public static void main(String[] args) {
		NumberOfSubarraysWithBoundedMaximum test = new NumberOfSubarraysWithBoundedMaximum();
		System.out.println(test.numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3));
		System.out.println(test.numSubarrayBoundedMax(new int[] { 2, 9, 2, 5, 6 }, 2, 8));
	}

	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		return this.getCount(nums, right) - this.getCount(nums, left - 1);
	}

	private int getCount(int[] nums, int bound) {
		int total = 0;
		int count = 0;
		for (int num : nums) {
			count = num <= bound ? count + 1 : 0;
			total += count;
		}
		return total;
	}

}

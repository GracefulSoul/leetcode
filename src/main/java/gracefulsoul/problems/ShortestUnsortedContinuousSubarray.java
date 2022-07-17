package gracefulsoul.problems;

public class ShortestUnsortedContinuousSubarray {

	// https://leetcode.com/submissions/detail/749409166/
	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
		System.out.println(test.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
		System.out.println(test.findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.findUnsortedSubarray(new int[] { 1 }));
	}

	public int findUnsortedSubarray(int[] nums) {
		int length = nums.length;
		int start = 0;
		int end = -1;
		int min = nums[length - 1];
		int max = nums[0];
		for (int idx = 1; idx < length; idx++) {
			max = Math.max(max, nums[idx]);
			min = Math.min(min, nums[length - 1 - idx]);
			if (nums[idx] < max) {
				end = idx;
			}
			if (nums[length - 1 - idx] > min) {
				start = length - 1 - idx;
			}
		}
		return end - start + 1;
	}

}

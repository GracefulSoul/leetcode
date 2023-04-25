package gracefulsoul.problems;

public class SmallestRangeI {

	// https://leetcode.com/problems/smallest-range-i/submissions/938894204/
	public static void main(String[] args) {
		SmallestRangeI test = new SmallestRangeI();
		System.out.println(test.smallestRangeI(new int[] { 1 }, 0));
		System.out.println(test.smallestRangeI(new int[] { 0, 10 }, 2));
		System.out.println(test.smallestRangeI(new int[] { 1, 3, 6 }, 3));
	}

	public int smallestRangeI(int[] nums, int k) {
		int max = nums[0];
		int min = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		return Math.max(0, max - min - (k * 2));
	}

}

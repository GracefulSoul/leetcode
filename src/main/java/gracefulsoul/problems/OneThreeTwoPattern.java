package gracefulsoul.problems;

public class OneThreeTwoPattern {

	// https://leetcode.com/submissions/detail/680592334/
	public static void main(String[] args) {
		OneThreeTwoPattern test = new OneThreeTwoPattern();
		System.out.println(test.find132pattern(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.find132pattern(new int[] { 3, 1, 4, 2 }));
		System.out.println(test.find132pattern(new int[] { -1, 3, 2, 0 }));
	}

	public boolean find132pattern(int[] nums) {
		int length = nums.length;
		int index = length;
		int max = Integer.MIN_VALUE;
		for (int idx = length - 1; idx >= 0; idx--) {
			if (nums[idx] < max) {
				return true;
			}
			while (index < length && nums[idx] > nums[index]) {
				max = nums[index++];
			}
			nums[--index] = nums[idx];
		}
		return false;
	}

}

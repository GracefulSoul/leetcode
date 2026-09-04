package gracefulsoul.problems;

public class SmallestStableIndexI {

	// https://leetcode.com/problems/smallest-stable-index-i/submissions/2130624461/
	public static void main(String[] args) {
		SmallestStableIndexI test = new SmallestStableIndexI();
		System.out.println(test.firstStableIndex(new int[] { 5, 0, 1, 4 }, 3));
		System.out.println(test.firstStableIndex(new int[] { 3, 2, 1 }, 1));
		System.out.println(test.firstStableIndex(new int[] { 0 }, 0));
	}

	public int firstStableIndex(int[] nums, int k) {
		int length = nums.length;
		int[] suffix = new int[length];
		suffix[length - 1] = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			suffix[i] = Math.min(suffix[i + 1], nums[i]);
		}
		int max = 0;
		for (int i = 0; i < length; i++) {
			max = Math.max(max, nums[i]);
			if (max <= k + suffix[i]) {
				return i;
			}
		}
		return -1;
	}

}

package gracefulsoul.problems;

public class LargestNumberAtLeastTwiceOfOthers {

	// https://leetcode.com/submissions/detail/854222717/
	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers test = new LargestNumberAtLeastTwiceOfOthers();
		System.out.println(test.dominantIndex(new int[] { 3, 6, 1, 0 }));
		System.out.println(test.dominantIndex(new int[] { 1, 2, 3, 4 }));
	}

	public int dominantIndex(int[] nums) {
		int max = -1;
		int index = -1;
		int second = -1;
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] > max) {
				second = max;
				max = nums[idx];
				index = idx;
			} else if (nums[idx] > second) {
				second = nums[idx];
			}
		}
		return max >= second * 2 ? index : -1;
	}

}

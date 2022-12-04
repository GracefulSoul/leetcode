package gracefulsoul.problems;

public class LargestNumberAtLeastTwiceOfOthers {

	// https://leetcode.com/submissions/detail/854211841/
	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers test = new LargestNumberAtLeastTwiceOfOthers();
		System.out.println(test.dominantIndex(new int[] { 3, 6, 1, 0 }));
		System.out.println(test.dominantIndex(new int[] { 1, 2, 3, 4 }));
	}

	public int dominantIndex(int[] nums) {
		int max = -1;
		int index = -1;
		int second = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				second = max;
				max = nums[i];
				index = i;
			} else if (nums[i] > second) {
				second = nums[i];
			}
		}
		return max >= second * 2 ? index : -1;
	}

}

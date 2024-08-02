package gracefulsoul.problems;

public class MinimumSwapsToGroupAll1sTogetherII {

	// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/submissions/1341703981/
	public static void main(String[] args) {
		MinimumSwapsToGroupAll1sTogetherII test = new MinimumSwapsToGroupAll1sTogetherII();
		System.out.println(test.minSwaps(new int[] { 0, 1, 0, 1, 1, 0, 0 }));
		System.out.println(test.minSwaps(new int[] { 0, 1, 1, 1, 0, 0, 1, 1, 0 }));
		System.out.println(test.minSwaps(new int[] { 1, 1, 0, 0, 1 }));
	}

	public int minSwaps(int[] nums) {
		int length = nums.length;
		int ones = 0;
		for (int num : nums) {
			if (num == 1) {
				ones++;
			}
		}
		int max = 0;
		for (int i = 0, count = 0; i < length + ones; i++) {
			if (i >= ones && nums[i - ones] == 1) {
				count--;
			}
			if (nums[i % length] == 1) {
				count++;
			}
			max = Math.max(max, count);
		}
		return ones - max;
	}

}

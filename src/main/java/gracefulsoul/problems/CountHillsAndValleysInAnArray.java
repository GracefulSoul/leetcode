package gracefulsoul.problems;

public class CountHillsAndValleysInAnArray {

	// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/submissions/1712982725/
	public static void main(String[] args) {
		CountHillsAndValleysInAnArray test = new CountHillsAndValleysInAnArray();
		System.out.println(test.countHillValley(new int[] { 2, 4, 1, 1, 6, 5 }));
		System.out.println(test.countHillValley(new int[] { 6, 6, 5, 5, 4, 1 }));
	}

	public int countHillValley(int[] nums) {
		int left = nums[0];
		int right = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			if (left < nums[i] && nums[i] > nums[i + 1] || left > nums[i] && nums[i] < nums[i + 1]) {
				right++;
				left = nums[i];
			}
		}
		return right;
	}

}

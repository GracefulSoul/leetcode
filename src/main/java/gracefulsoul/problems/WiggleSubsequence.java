package gracefulsoul.problems;

public class WiggleSubsequence {

	// https://leetcode.com/submissions/detail/634693779/
	public static void main(String[] args) {
		WiggleSubsequence test = new WiggleSubsequence();
		System.out.println(test.wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
		System.out.println(test.wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
		System.out.println(test.wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}

	public int wiggleMaxLength(int[] nums) {
		int up = 1;
		int down = 1;
		for (int idx = 1; idx < nums.length; idx++) {
			if (nums[idx] > nums[idx - 1]) {
				up = down + 1;
			} else if (nums[idx] < nums[idx - 1]) {
				down = up + 1;
			}
		}
		return Math.max(up, down);
	}

}

package gracefulsoul.problems;

public class JumpGame {

	// https://leetcode.com/submissions/detail/502732061/
	public static void main(String[] args) {
		JumpGame test = new JumpGame();
		System.out.println(test.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(test.canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public boolean canJump(int[] nums) {
		int position = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			if (position < idx) {
				return false;
			}
			position = Math.max(idx + nums[idx], position);
		}
		return true;
	}

}

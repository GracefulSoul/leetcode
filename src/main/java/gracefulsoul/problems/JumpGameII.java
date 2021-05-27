package gracefulsoul.problems;

public class JumpGameII {

	// https://leetcode.com/submissions/detail/498893061/
	public static void main(String[] args) {
		JumpGameII test = new JumpGameII();
		System.out.println(test.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(test.jump(new int[] { 2, 3, 0, 1, 4 }));
	}

	public int jump(int[] nums) {
		int count = 0;
		int position = 0;
		int target = 0;
		for (int idx = 0; idx < nums.length - 1; idx++) {
			target = Math.max(target, idx + nums[idx]);
			if (idx == position) {
				count++;
				position = target;
			}
			if (position == nums.length - 1) {
				break;
			}
		}
		return count;
	}

}

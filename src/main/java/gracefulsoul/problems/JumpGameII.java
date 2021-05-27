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
		int target = 0;
		int max = 0;
		for (int idx = 0; idx < nums.length - 1; idx++) {
			max = Math.max(max, idx + nums[idx]);
			if (idx == target) {
				count++;
				target = max;
			}
			if (target == nums.length - 1) {
				break;
			}
		}
		return count;
	}

}

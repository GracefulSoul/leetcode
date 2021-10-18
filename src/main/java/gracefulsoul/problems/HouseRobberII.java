package gracefulsoul.problems;

public class HouseRobberII {

	// https://leetcode.com/submissions/detail/573008820/
	public static void main(String[] args) {
		HouseRobberII test = new HouseRobberII();
		System.out.println(test.rob(new int[] { 2, 3, 2 }));
		System.out.println(test.rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(test.rob(new int[] { 1, 2, 3 }));
	}

	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else {
			return Math.max(this.getMax(nums, 0), this.getMax(nums, 1));
		}
	}

	private int getMax(int[] nums, int start) {
		int pre = 0;
		int cur = 0;
		for (int i = start; i < nums.length + start - 1; i++) {
			int temp = cur;
			cur = Math.max(pre + nums[i], cur);
			pre = temp;
		}
		return cur;
	}

}

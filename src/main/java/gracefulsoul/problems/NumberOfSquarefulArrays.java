package gracefulsoul.problems;

public class NumberOfSquarefulArrays {

	// https://leetcode.com/problems/number-of-squareful-arrays/submissions/1057548265/
	public static void main(String[] args) {
		NumberOfSquarefulArrays test = new NumberOfSquarefulArrays();
		System.out.println(test.numSquarefulPerms(new int[] { 1, 17, 8 }));
		System.out.println(test.numSquarefulPerms(new int[] { 2, 2, 2 }));
	}

	public int numSquarefulPerms(int[] nums) {
		return this.dfs(nums, 0);
	}

	private int dfs(int[] nums, int index) {
		if (index >= nums.length) {
			return 1;
		}
		int sum = 0;
		for (int i = index; i < nums.length; i++) {
			if (!this.isSwapable(nums, index, i)) {
				continue;
			}
			this.swap(nums, index, i);
			if (index == 0 || this.isSquareful(nums, index)) {
				sum += this.dfs(nums, index + 1);
			}
			this.swap(nums, index, i);
		}
		return sum;
	}

	private boolean isSwapable(int[] nums, int i, int j) {
		while (i < j) {
			if (nums[i++] == nums[j]) {
				return false;
			}
		}
		return true;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private boolean isSquareful(int[] nums, int idx) {
		int sqrt = (int) Math.sqrt(nums[idx] + nums[idx - 1]);
		return (sqrt * sqrt) == (nums[idx] + nums[idx - 1]);
	}

}

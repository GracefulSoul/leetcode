package gracefulsoul.problems;

public class RangeSumQueryImmutable {

	// https://leetcode.com/submissions/detail/602507642/
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
		System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
		System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
	}

}

class NumArray {

	private int[] nums;

	public NumArray(int[] nums) {
		int length = nums.length;
		this.nums = new int[length];
		for (int idx = 0; idx < length; idx++) {
			if (idx == 0) {
				this.nums[idx] = nums[idx];
			} else {
				this.nums[idx] = this.nums[idx - 1] + nums[idx];
			}
		}
	}

	public int sumRange(int left, int right) {
		if (left == 0) {
			return nums[right];
		} else {
			return nums[right] - nums[left - 1];
		}
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
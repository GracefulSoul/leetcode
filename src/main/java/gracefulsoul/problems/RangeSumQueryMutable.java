package gracefulsoul.problems;

public class RangeSumQueryMutable {

	// https://leetcode.com/submissions/detail/603888213/
	public static void main(String[] args) {
		NumArray2 numArray = new NumArray2(new int[] {1, 3, 5});
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
		numArray.update(1, 2); // nums = [1, 2, 5]
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
	}

}

class NumArray2 {

	private int[] nums;
	private int sum;

	public NumArray2(int[] nums) {
		this.nums = nums;
		this.sum = 0;
		for (int num : nums) {
			this.sum += num;
		}
	}

	public void update(int index, int val) {
		this.sum -= this.nums[index] - val;
		this.nums[index] = val;
	}

	public int sumRange(int left, int right) {
		int temp = 0;
		if ((right - left) < this.nums.length / 2) {
			for (int idx = left; idx <= right; idx++) {
				temp += this.nums[idx];
			}
		} else {
			temp = this.sum;
			for (int idx = 0; idx < left; idx++) {
				temp -= this.nums[idx];
			}
			for (int idx = right + 1; idx < this.nums.length; idx++) {
				temp -= this.nums[idx];
			}
		}
		return temp;
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
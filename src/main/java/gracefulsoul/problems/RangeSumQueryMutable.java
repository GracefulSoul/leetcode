package gracefulsoul.problems;

public class RangeSumQueryMutable {

	// https://leetcode.com/submissions/detail/603835113/
	public static void main(String[] args) {
		NumArray2 numArray = new NumArray2(new int[] {1, 3, 5});
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
		numArray.update(1, 2);   // nums = [1, 2, 5]
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
	}

}

class NumArray2 {

	private int[] nums;
	private int sum;

	public NumArray2(int[] nums) {
		this.nums = nums;
		sum = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			sum += nums[idx];
		}
	}

	public void update(int index, int val) {
		sum -= nums[index] - val;
		nums[index] = val;
	}

	public int sumRange(int left, int right) {
		int temp = 0;
		if ((right - left) < nums.length / 2) {
			for (int idx = left; idx <= right; idx++) {
				temp += nums[idx];
			}
		} else {
			temp = sum;
			for (int idx = 0; idx < left; idx++) {
				temp -= nums[idx];
			}
			for (int idx = right + 1; idx < nums.length; idx++) {
				temp -= nums[idx];
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
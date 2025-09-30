package gracefulsoul.problems;

public class FindTriangularSumOfAnArray {

	// https://leetcode.com/problems/find-triangular-sum-of-an-array/submissions/1787104596/
	public static void main(String[] args) {
		FindTriangularSumOfAnArray test = new FindTriangularSumOfAnArray();
		System.out.println(test.triangularSum(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.triangularSum(new int[] { 5 }));
	}

	public int triangularSum(int[] nums) {
		return this.find(nums, nums.length);
	}

	private int find(int[] nums, int index) {
		if (index == 1) {
			return nums[0];
		} else {
			for (int i = 0; i < index - 1; i++) {
				nums[i] = (nums[i] + nums[i + 1]) % 10;
			}
			return this.find(nums, index - 1);
		}
	}

}

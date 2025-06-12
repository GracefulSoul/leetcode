package gracefulsoul.problems;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {

	// https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/submissions/1661792026/
	public static void main(String[] args) {
		MaximumDifferenceBetweenAdjacentElementsInACircularArray test = new MaximumDifferenceBetweenAdjacentElementsInACircularArray();
		System.out.println(test.maxAdjacentDistance(new int[] { 1, 2, 4 }));
		System.out.println(test.maxAdjacentDistance(new int[] { -5, -10, -5 }));
	}

	public int maxAdjacentDistance(int[] nums) {
		int length = nums.length;
		int result = this.getAbsoluteDifference(nums[0], nums[length - 1]);
		for (int i = 0; i < length - 1; i++) {
			result = Math.max(result, this.getAbsoluteDifference(nums[i], nums[i + 1]));
		}
		return result;
	}

	private int getAbsoluteDifference(int num1, int num2) {
		if (num1 > num2) {
			return num1 - num2;
		} else {
			return num2 - num1;
		}
	}

}

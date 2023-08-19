package gracefulsoul.problems;

import java.util.Arrays;

public class LargestPerimeterTriangle {

	// https://leetcode.com/problems/largest-perimeter-triangle/submissions/1025689356/
	public static void main(String[] args) {
		LargestPerimeterTriangle test = new LargestPerimeterTriangle();
		System.out.println(test.largestPerimeter(new int[] { 2, 1, 2 }));
		System.out.println(test.largestPerimeter(new int[] { 1, 2, 1, 10 }));
	}

	public int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		for (int i = nums.length - 1; i > 1; i--) {
			if (nums[i] < nums[i - 1] + nums[i - 2]) {
				return nums[i] + nums[i - 1] + nums[i - 2];
			}
		}
		return 0;
	}

}

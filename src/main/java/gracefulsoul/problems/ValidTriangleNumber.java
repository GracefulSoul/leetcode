package gracefulsoul.problems;

import java.util.Arrays;

public class ValidTriangleNumber {

	// https://leetcode.com/submissions/detail/768961421/
	public static void main(String[] args) {
		ValidTriangleNumber test = new ValidTriangleNumber();
		System.out.println(test.triangleNumber(new int[] { 2, 2, 3, 4 }));
		System.out.println(test.triangleNumber(new int[] { 4, 2, 3, 4 }));
	}

	public int triangleNumber(int[] nums) {
		if (nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int count = 0;
		for (int idx = 2; idx < nums.length; idx++) {
			int left = 0;
			int right = idx - 1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[idx]) {
					count += right - left;
					right--;
				} else {
					left++;
				}
			}
		}
		return count;
	}

}

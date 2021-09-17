package gracefulsoul.problems;

import java.util.Arrays;

public class TwoSumII {

	// https://leetcode.com/submissions/detail/556821729/
	public static void main(String[] args) {
		TwoSumII test = new TwoSumII();
		System.out.println(Arrays.toString(test.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(test.twoSum(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(test.twoSum(new int[] { -1, 0 }, -1)));
	}

	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				break;
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[] { left + 1, right + 1 };
	}

}

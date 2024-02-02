package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

	// https://leetcode.com/problems/sequential-digits/submissions/1163787210/
	public static void main(String[] args) {
		SequentialDigits test = new SequentialDigits();
		System.out.println(test.sequentialDigits(100, 300));
		System.out.println(test.sequentialDigits(1000, 13000));
	}

	public List<Integer> sequentialDigits(int low, int high) {
		int[] nums = {
			12, 23, 34, 45, 56, 67, 78, 89,
			123, 234, 345, 456, 567, 678, 789,
			1234, 2345, 3456, 4567, 5678, 6789,
			12345, 23456, 34567, 45678, 56789,
			123456, 234567, 345678, 456789,
			1234567, 2345678, 3456789,
			12345678, 23456789,
			123456789
		};
		List<Integer> result = new ArrayList<>();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] < low) {
				continue;
			} else if (nums[i] > high) {
				break;
			} else {
				result.add(nums[i]);
			}
		}
		return result;
	}

}

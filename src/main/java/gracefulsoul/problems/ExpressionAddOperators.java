package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	// https://leetcode.com/submissions/detail/595409731/
	public static void main(String[] args) {
		ExpressionAddOperators test = new ExpressionAddOperators();
		System.out.println(test.addOperators("123", 6));
		System.out.println(test.addOperators("232", 8));
		System.out.println(test.addOperators("105", 5));
		System.out.println(test.addOperators("00", 0));
		System.out.println(test.addOperators("3456237490", 9191));
	}

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		if (Long.valueOf(num) > Integer.MAX_VALUE) {
			return result;
		}
		char[] nums = num.toCharArray();
		char[] path = new char[nums.length * 2 - 1];
		long val = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			val = val * 10 + nums[idx] - '0';
			path[idx] = nums[idx];
			this.recursive(result, target, nums, path, 0, val, idx + 1, idx + 1);
			if (val == 0) {
				break;
			}
		}
		return result;
	}

	private void recursive(List<String> result, int target, char[] nums, char[] path, long left, long right, int numsIdx, int pathIdx) {
		if (numsIdx == nums.length) {
			if (left + right == target) {
				result.add(new String(path, 0, pathIdx));
			}
			return;
		}
		long val = 0;
		int j = pathIdx + 1;
		for (int i = numsIdx; i < nums.length; i++) {
			val = val * 10 + nums[i] - '0';
			path[j++] = nums[i];
			path[pathIdx] = '+';
			this.recursive(result, target, nums, path, left + right, val, i + 1, j);
			path[pathIdx] = '-';
			this.recursive(result, target, nums, path, left + right, -val, i + 1, j);
			path[pathIdx] = '*';
			this.recursive(result, target, nums, path, left, right * val, i + 1, j);
			if (nums[numsIdx] == '0') {
				return;
			}
		}
	}

}

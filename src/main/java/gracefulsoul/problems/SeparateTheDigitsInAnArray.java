package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class SeparateTheDigitsInAnArray {

	// https://leetcode.com/problems/separate-the-digits-in-an-array/submissions/2000474322/
	public static void main(String[] args) {
		SeparateTheDigitsInAnArray test = new SeparateTheDigitsInAnArray();
		PrintUtil.print(test.separateDigits(new int[] { 13, 25, 83, 77 }));
		PrintUtil.print(test.separateDigits(new int[] { 7, 1, 3, 9 }));
	}

	public int[] separateDigits(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int e = nums[i];
			while (e > 0) {
				temp.add(e % 10);
				e /= 10;
			}
		}
		int size = temp.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = temp.get(size - i - 1);
		}
		return result;
	}

}

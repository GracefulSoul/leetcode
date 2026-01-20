package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class ConstructTheMinimumBitwiseArrayI {

	// https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/submissions/1890882506/
	public static void main(String[] args) {
		ConstructTheMinimumBitwiseArrayI test = new ConstructTheMinimumBitwiseArrayI();
		PrintUtil.print(test.minBitwiseArray(Arrays.asList(2, 3, 5, 7)));
		PrintUtil.print(test.minBitwiseArray(Arrays.asList(11, 13, 31)));
	}

	public int[] minBitwiseArray(List<Integer> nums) {
		int size = nums.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int num = nums.get(i);
			if ((num & 1) == 1) {
				result[i] = num & ~(((num + 1) & ~num) >> 1);
			} else {
				result[i] = -1;
			}
		}
		return result;
	}

}

package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class ConstructTheMinimumBitwiseArrayII {

	// https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/submissions/1892016535/
	public static void main(String[] args) {
		ConstructTheMinimumBitwiseArrayII test = new ConstructTheMinimumBitwiseArrayII();
		PrintUtil.print(test.minBitwiseArray(Arrays.asList(2, 3, 5, 7)));
		PrintUtil.print(test.minBitwiseArray(Arrays.asList(11, 13, 31)));
	}

	public int[] minBitwiseArray(List<Integer> nums) {
		int size = nums.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int num = nums.get(i);
			result[i] = -1;
			int d = 1;
			while ((num & d) != 0) {
				result[i] = num - d;
				d <<= 1;
			}
		}
		return result;
	}

}

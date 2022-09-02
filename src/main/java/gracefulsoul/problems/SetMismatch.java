package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SetMismatch {

	// https://leetcode.com/submissions/detail/789524318/
	public static void main(String[] args) {
		SetMismatch test = new SetMismatch();
		PrintUtil.print(test.findErrorNums(new int[] { 1, 2, 2, 4 }));
		PrintUtil.print(test.findErrorNums(new int[] { 1, 1 }));
	}

	public int[] findErrorNums(int[] nums) {
		int[] count = new int[nums.length + 1];
		int[] result = new int[2];
		for (int num : nums) {
			count[num]++;
		}
		for (int idx = 0; idx < count.length; idx++) {
			switch (count[idx]) {
				case 0: result[1] = idx; break;
				case 2: result[0] = idx; break;
			}
		}
		return result;
	}

}

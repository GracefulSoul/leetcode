package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SingleNumberIII {

	// https://leetcode.com/submissions/detail/590226962/
	public static void main(String[] args) {
		SingleNumberIII test = new SingleNumberIII();
		PrintUtil.print(test.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
		PrintUtil.print(test.singleNumber(new int[] { -1, 0 }));
		PrintUtil.print(test.singleNumber(new int[] { 0, 1 }));
	}

	public int[] singleNumber(int[] nums) {
		int bit = 0;
		for (int num : nums) {
			bit ^= num;
		}
		int diff = bit & -bit;
		int single = 0;
		for (int num : nums) {
			if ((diff & num) != 0) {
				single ^= num;
			}
		}
		return new int[] { single, bit ^ single };
	}

}

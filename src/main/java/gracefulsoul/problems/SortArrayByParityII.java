package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SortArrayByParityII {

	// https://leetcode.com/problems/sort-array-by-parity-ii/submissions/947775184/
	public static void main(String[] args) {
		SortArrayByParityII test = new SortArrayByParityII();
		PrintUtil.print(test.sortArrayByParityII(new int[] { 4, 2, 5, 7 }));
		PrintUtil.print(test.sortArrayByParityII(new int[] { 2, 3 }));
	}

	public int[] sortArrayByParityII(int[] nums) {
		int even = 0;
		int odd = 1;
		while (even < nums.length && odd < nums.length) {
			if (nums[even] % 2 == 0) {
				even += 2;
			} else {
				int temp = nums[even];
				nums[even] = nums[odd];
				nums[odd] = temp;
				odd += 2;
			}
		}
		return nums;
	}

}

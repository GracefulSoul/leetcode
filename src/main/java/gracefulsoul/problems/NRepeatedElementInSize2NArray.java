package gracefulsoul.problems;

public class NRepeatedElementInSize2NArray {

	// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/submissions/1007390058/
	public static void main(String[] args) {
		NRepeatedElementInSize2NArray test = new NRepeatedElementInSize2NArray();
		System.out.println(test.repeatedNTimes(new int[] { 1, 2, 3, 3 }));
		System.out.println(test.repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
		System.out.println(test.repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
	}

	public int repeatedNTimes(int[] nums) {
		int length = nums.length;
		int n = length / 2;
		for (int i = 0; i < length; i++) {
			int count = 1;
			for (int j = i + 1; j < length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
			if (count == n) {
				return nums[i];
			}
		}
		return 0;
	}

}

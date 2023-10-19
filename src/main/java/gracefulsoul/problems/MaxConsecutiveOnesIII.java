package gracefulsoul.problems;

public class MaxConsecutiveOnesIII {

	// https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1079085621/
	public static void main(String[] args) {
		MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
		System.out.println(test.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
		System.out.println(test.longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
	}

	public int longestOnes(int[] nums, int k) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j++] == 0) {
				k--;
			}
			if (k < 0 && nums[i++] == 0) {
				k++;
			}
		}
		return j - i;
	}

}

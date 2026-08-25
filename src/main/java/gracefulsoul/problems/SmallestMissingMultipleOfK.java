package gracefulsoul.problems;

public class SmallestMissingMultipleOfK {

	// https://leetcode.com/problems/smallest-missing-multiple-of-k/submissions/2119599541/
	public static void main(String[] args) {
		SmallestMissingMultipleOfK test = new SmallestMissingMultipleOfK();
		System.out.println(test.missingMultiple(new int[] { 8, 2, 3, 4, 6 }, 2));
		System.out.println(test.missingMultiple(new int[] { 1, 4, 7, 10, 15 }, 5));
	}

	public int missingMultiple(int[] nums, int k) {
		int result = k;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == result) {
				result += k;
				i = -1;
			}
		}
		return result;
	}

}

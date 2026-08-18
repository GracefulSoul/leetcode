package gracefulsoul.problems;

public class FindTheLargestAlmostMissingInteger {

	// https://leetcode.com/problems/find-the-largest-almost-missing-integer/submissions/2111295523/
	public static void main(String[] args) {
		FindTheLargestAlmostMissingInteger test = new FindTheLargestAlmostMissingInteger();
		System.out.println(test.largestInteger(new int[] { 3, 9, 2, 1, 7 }, 3));
		System.out.println(test.largestInteger(new int[] { 3, 9, 7, 2, 1, 7 }, 4));
		System.out.println(test.largestInteger(new int[] { 0, 0 }, 1));
	}

	public int largestInteger(int[] nums, int k) {
		int[] counts = new int[51];
		for (int num : nums) {
			counts[num]++;
		}
		int result = -1;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int num = nums[i];
			if (k == length || (counts[num] == 1 && (k == 1 || i == 0 || i == length - 1))) {
				result = Math.max(result, num);
			}
		}
		return result;
	}

}

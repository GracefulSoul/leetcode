package gracefulsoul.problems;

public class CountEqualAndDivisiblePairsInAnArray {

	// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/submissions/1609384126/
	public static void main(String[] args) {
		CountEqualAndDivisiblePairsInAnArray test = new CountEqualAndDivisiblePairsInAnArray();
		System.out.println(test.countPairs(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2));
		System.out.println(test.countPairs(new int[] { 1, 2, 3, 4 }, 1));
	}

	public int countPairs(int[] nums, int k) {
		int length = nums.length;
		int result = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] == nums[j] && i * j % k == 0) {
					result++;
				}
			}
		}
		return result;
	}

}

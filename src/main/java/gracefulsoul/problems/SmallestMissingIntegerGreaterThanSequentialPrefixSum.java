package gracefulsoul.problems;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {

	// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/submissions/2102752724/
	public static void main(String[] args) {
		SmallestMissingIntegerGreaterThanSequentialPrefixSum test = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
		System.out.println(test.missingInteger(new int[] { 1, 2, 3, 2, 5 }));
		System.out.println(test.missingInteger(new int[] { 3, 4, 5, 1, 12, 14, 13 }));
	}

	public int missingInteger(int[] nums) {
		boolean[] seen = new boolean[52];
		seen[nums[0]] = true;
		boolean sequential = true;
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sequential && nums[i] == nums[i - 1] + 1) {
				sum += nums[i];
			} else {
				sequential = false;
				if (50 < sum) {
					return sum;
				}
			}
			seen[nums[i]] = true;
		}
		for (int i = sum; i < 52; i++) {
			if (!seen[i]) {
				return i;
			}
		}
		return sum;
	}

}

package gracefulsoul.problems;

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

	// https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/submissions/1827764118/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 test = new MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1();
		System.out.println(test.minOperations(new int[] { 2, 6, 3, 4 }));
		System.out.println(test.minOperations(new int[] { 2, 10, 6, 14 }));
	}

	public int minOperations(int[] nums) {
		int length = nums.length;
		int count = 0;
		int gcd = 0;
		for (int num : nums) {
			if (num == 1) {
				count++;
			}
			gcd = this.getGcd(gcd, num);
		}
		if (count > 0) {
			return length - count;
		}
		if (gcd > 1) {
			return -1;
		}
		int min = length;
		for (int i = 0; i < length; i++) {
			int curr = 0;
			for (int j = i; j < length; j++) {
				curr = this.getGcd(curr, nums[j]);
				if (curr == 1) {
					min = Math.min(min, j - i + 1);
					break;
				}
			}
		}
		return min + length - 2;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}

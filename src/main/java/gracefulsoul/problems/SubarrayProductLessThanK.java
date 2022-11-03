package gracefulsoul.problems;

public class SubarrayProductLessThanK {

	// https://leetcode.com/submissions/detail/835993879/
	public static void main(String[] args) {
		SubarrayProductLessThanK test = new SubarrayProductLessThanK();
		System.out.println(test.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
		System.out.println(test.numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k == 0) {
			return 0;
		}
		int count = 0;
		int product = 1;
		for (int i = 0, j = 0; i < nums.length; i++) {
			product *= nums[i];
			while (j <= i && product >= k) {
				product /= nums[j++];
			}
			count += i - j + 1;
		}
		return count;
	}

}

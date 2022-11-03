package gracefulsoul.problems;

public class SubarrayProductLessThanK {

	// https://leetcode.com/submissions/detail/835974832/
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
		for (int i = 0, j = 0; j < nums.length; j++) {
			product *= nums[j];
			while (i <= j && product >= k) {
				product /= nums[i++];
			}
			count += j - i + 1;
		}
		return count;
	}

}

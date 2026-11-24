package gracefulsoul.problems;

public class MaximumSubarrayWithEqualProducts {

	// https://leetcode.com/problems/maximum-subarray-with-equal-products/submissions/2202676092/
	public static void main(String[] args) {
		MaximumSubarrayWithEqualProducts test = new MaximumSubarrayWithEqualProducts();
		System.out.println(test.maxLength(new int[] { 1, 2, 1, 2, 1, 1, 1 }));
		System.out.println(test.maxLength(new int[] { 2, 3, 4, 5, 6 }));
		System.out.println(test.maxLength(new int[] { 1, 2, 3, 1, 4, 5, 1 }));
	}

	public int maxLength(int[] nums) {
		int result = 2;
		int i = 0;
		int product = 1;
		for (int j = 0; j < nums.length; j++) {
			int num = nums[j];
			while (1 < this.gcd(product, num)) {
				product /= nums[i++];
			}
			product *= num;
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : this.gcd(b, a % b);
	}

}

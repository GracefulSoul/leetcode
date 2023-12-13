package gracefulsoul.problems;

public class MaximumProductOfTwoElementsInAnArray {

	// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/1117986154/
	public static void main(String[] args) {
		MaximumProductOfTwoElementsInAnArray test = new MaximumProductOfTwoElementsInAnArray();
		System.out.println(test.maxProduct(new int[] { 3, 4, 5, 2 }));
		System.out.println(test.maxProduct(new int[] { 1, 5, 4, 5 }));
		System.out.println(test.maxProduct(new int[] { 3, 7 }));
	}

	public int maxProduct(int[] nums) {
		int[] max = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
		for (int num : nums) {
			if (num > max[0]) {
				max[1] = max[0];
				max[0] = num;
			} else if (num > max[1]) {
				max[1] = num;
			}
		}
		return (max[0] - 1) * (max[1] - 1);
	}

}

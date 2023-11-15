package gracefulsoul.problems;

public class MaximumElementAfterDecreasingAndRearranging {

	// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/submissions/1099324660/
	public static void main(String[] args) {
		MaximumElementAfterDecreasingAndRearranging test = new MaximumElementAfterDecreasingAndRearranging();
		System.out.println(test.maximumElementAfterDecrementingAndRearranging(new int[] { 2, 2, 1, 2, 1 }));
		System.out.println(test.maximumElementAfterDecrementingAndRearranging(new int[] { 100, 1, 1000 }));
		System.out.println(test.maximumElementAfterDecrementingAndRearranging(new int[] { 1, 2, 3, 4, 5 }));
	}

	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int length = arr.length;
		int[] count = new int[length];
		for (int i = 0; i < length; i++) {
			count[Math.min(arr[i] - 1, length - 1)]++;
		}
		int result = 1;
		for (int i = 1; i < length; i++) {
			result = Math.min(i + 1, result + count[i]);
		}
		return result;
	}

}

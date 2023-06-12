package gracefulsoul.problems;

public class MaximumValueAtAGivenIndexInABoundedArray {

	// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/submissions/968395013/
	public static void main(String[] args) {
		MaximumValueAtAGivenIndexInABoundedArray test = new MaximumValueAtAGivenIndexInABoundedArray();
		System.out.println(test.maxValue(4, 2, 6));
		System.out.println(test.maxValue(6, 1, 10));
	}

	public int maxValue(int n, int index, int maxSum) {
		maxSum -= n;
		int left = 0;
		int right = maxSum;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (this.isMaxValue(n, index, mid) <= maxSum) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left + 1;
	}

	private long isMaxValue(int n, int index, int a) {
		int b = Math.max(a - index, 0);
		long result = (long) (a + b) * (a - b + 1) / 2;
		b = Math.max(a - ((n - 1) - index), 0);
		result += (long) (a + b) * (a - b + 1) / 2;
		return result - a;
	}

}

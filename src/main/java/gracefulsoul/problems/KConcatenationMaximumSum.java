package gracefulsoul.problems;

public class KConcatenationMaximumSum {

	// https://leetcode.com/problems/k-concatenation-maximum-sum/submissions/1396950798/
	public static void main(String[] args) {
		KConcatenationMaximumSum test = new KConcatenationMaximumSum();
		System.out.println(test.kConcatenationMaxSum(new int[] { 1, 2 }, 3));
		System.out.println(test.kConcatenationMaxSum(new int[] { 1, -2, 1 }, 5));
		System.out.println(test.kConcatenationMaxSum(new int[] { -1, -2 }, 7));
	}

	public int kConcatenationMaxSum(int[] arr, int k) {
		long currentMax = arr[0] > 0 ? arr[0] : 0L;
		long max = currentMax;
		long sum = arr[0];
		int length = arr.length;
		for (int i = 1; i < Math.min(k, 2) * length; i++) {
			currentMax = Math.max(currentMax + arr[i % length], arr[i % length]);
			max = Math.max(currentMax, max);
			if (i < length) {
				sum += arr[i];
			}
		}
		while (sum > 0 && --k >= 2) {
			max = (max + sum) % 1000000007;
		}
		return (int) max % 1000000007;
	}

}

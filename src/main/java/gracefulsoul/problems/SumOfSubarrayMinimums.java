package gracefulsoul.problems;

public class SumOfSubarrayMinimums {

	// https://leetcode.com/problems/sum-of-subarray-minimums/submissions/938895139/
	public static void main(String[] args) {
		SumOfSubarrayMinimums test = new SumOfSubarrayMinimums();
		System.out.println(test.sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
		System.out.println(test.sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 }));
	}

	public int sumSubarrayMins(int[] arr) {
		double mod = 1000000007d;
		int length = arr.length;
		int[] stack = new int[length + 1];
		int index = 0;
		int[] dp = new int[length];
		long result = dp[0] = arr[0];
		for (int i = 1; i < length; i++) {
			while (index >= 0 && arr[stack[index]] >= arr[i]) {
				index--;
			}
			dp[i] = index < 0 ? arr[i] * (i + 1) : dp[stack[index]] + arr[i] * (i - stack[index]);
			result += dp[i];
			stack[++index] = i;
		}
		return (int) (result % mod);
	}

}

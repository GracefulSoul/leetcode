package gracefulsoul.problems;

public class MaxChunksToMakeSortedII {

	// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/submissions/861368346/
	public static void main(String[] args) {
		MaxChunksToMakeSortedII test = new MaxChunksToMakeSortedII();
		System.out.println(test.maxChunksToSorted(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(test.maxChunksToSorted(new int[] { 2, 1, 3, 4, 4 }));
	}

	public int maxChunksToSorted(int[] arr) {
		int length = arr.length;
		int[] dp = new int[length];
		dp[0] = arr[0];
		for (int idx = 1; idx < length; idx++) {
			dp[idx] = Math.max(dp[idx - 1], arr[idx]);
		}
		int result = 0;
		int min = arr[length - 1];
		for (int idx = length - 2; idx >= 0; idx--) {
			if (dp[idx] <= min) {
				result++;
			}
			min = Math.min(min, arr[idx]);
		}
		return result + 1;
	}

}

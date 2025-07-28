package gracefulsoul.problems;

public class PalindromePartitioningIII {

	// https://leetcode.com/problems/palindrome-partitioning-iii/submissions/1714476908/
	public static void main(String[] args) {
		PalindromePartitioningIII test = new PalindromePartitioningIII();
		System.out.println(test.palindromePartition("abc", 2));
		System.out.println(test.palindromePartition("aabbc", 3));
		System.out.println(test.palindromePartition("leetcode", 8));
	}

	public int palindromePartition(String s, int k) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[][] cost = new int[length][length];
		int[][] dp = new int[k + 1][length];
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i + 1; j < length; j++) {
				cost[i][j] = cost[i + 1][j - 1];
				if (charArray[i] != charArray[j]) {
					cost[i][j] += 1;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			dp[1][i] = cost[0][i];
		}
		for (int i = 2; i <= k; i++) {
			for (int end = i - 1; end < length; end++) {
				int min = length;
				for (int start = end - 1; start >= i - 2; start--) {
					min = Math.min(min, dp[i - 1][start] + cost[start + 1][end]);
				}
				dp[i][end] = min;
			}
		}
		return dp[k][length - 1];
	}

}

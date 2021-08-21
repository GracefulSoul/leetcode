package gracefulsoul.problems;

public class PalindromePartitioningII {

	// https://leetcode.com/submissions/detail/541704225/
	public static void main(String[] args) {
		PalindromePartitioningII test = new PalindromePartitioningII();
		System.out.println(test.minCut("aab"));
		System.out.println(test.minCut("a"));
		System.out.println(test.minCut("ab"));
	}

	public int minCut(String s) {
		boolean dp[][] = new boolean[s.length() + 1][s.length() + 1];
		int min[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			min[i] = i;
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
					min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
				}
			}
		}
		return min[s.length() - 1];
	}

}

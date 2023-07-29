package gracefulsoul.problems;

public class DeleteColumnsToMakeSortedIII {

	// https://leetcode.com/problems/delete-columns-to-make-sorted-iii/submissions/1006535820/
	public static void main(String[] args) {
		DeleteColumnsToMakeSortedIII test = new DeleteColumnsToMakeSortedIII();
		System.out.println(test.minDeletionSize(new String[] { "babca", "bbazb" }));
		System.out.println(test.minDeletionSize(new String[] { "edcba" }));
		System.out.println(test.minDeletionSize(new String[] { "ghi", "def", "abc" }));
	}

	public int minDeletionSize(String[] strs) {
		int max = 1;
		int length = strs[0].length();
		int[] dp = new int[length];
		for (int i = 0; i < length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (this.isLexicographicOrder(strs, i, j)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return length - max;
	}

	private boolean isLexicographicOrder(String[] strs, int i, int j) {
		for (String str : strs) {
			if (str.charAt(i) < str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}

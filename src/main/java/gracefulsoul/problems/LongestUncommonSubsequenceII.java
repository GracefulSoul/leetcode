package gracefulsoul.problems;

public class LongestUncommonSubsequenceII {

	// https://leetcode.com/submissions/detail/717257423/
	public static void main(String[] args) {
		LongestUncommonSubsequenceII test = new LongestUncommonSubsequenceII();
		System.out.println(test.findLUSlength(new String[] { "aba", "cdc", "eae" }));
		System.out.println(test.findLUSlength(new String[] { "aaa", "aaa", "aa" }));
	}

	public int findLUSlength(String[] strs) {
		int result = -1;
		int length = strs.length;
		for (int i = 0; i < length; i++) {
			if (strs[i].length() < result) {
				continue;
			}
			int j = -1;
			while (++j < length) {
				if (i != j && this.isSubsequence(strs[i], strs[j])) {
					break;
				}
			}
			if (j == length) {
				result = Math.max(result, strs[i].length());
			}
		}
		return result;
	}

	private boolean isSubsequence(String s1, String s2) {
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j++)) {
				i++;
			}
		}
		return i == s1.length();
	}

}

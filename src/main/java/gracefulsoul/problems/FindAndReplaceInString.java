package gracefulsoul.problems;

public class FindAndReplaceInString {

	// https://leetcode.com/problems/find-and-replace-in-string/submissions/893971229/
	public static void main(String[] args) {
		FindAndReplaceInString test = new FindAndReplaceInString();
		System.out.println(test.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" }, new String[] { "eee", "ffff" }));
		System.out.println(test.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" }, new String[] { "eee", "ffff" }));
	}

	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		int[] dp = new int[s.length()];
		for (int idx = 0; idx < indices.length; idx++) {
			if (s.startsWith(sources[idx], indices[idx])) {
				dp[indices[idx]] = idx + 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (index < s.length()) {
			if (dp[index] > 0) {
				sb.append(targets[dp[index] - 1]);
				index += sources[dp[index] - 1].length();
			} else {
				sb.append(s.charAt(index++));
			}
		}
		return sb.toString();
	}

}

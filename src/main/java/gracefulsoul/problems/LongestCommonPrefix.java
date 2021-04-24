package gracefulsoul.problems;

public class LongestCommonPrefix {

	// https://leetcode.com/submissions/detail/483836409/
	public static void main(String[] args) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		System.out.println(test.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(test.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(test.longestCommonPrefix(new String[] { "ab", "a" }));
	}

	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];
		if (strs.length == 1) {
			return prefix;
		}
		for (int idx = 1; idx < strs.length; idx++) {
			while (strs[idx].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

}

package gracefulsoul.problems;

public class MaximumProductOfWordLengths {

	// https://leetcode.com/submissions/detail/607402920/
	public static void main(String[] args) {
		MaximumProductOfWordLengths test = new MaximumProductOfWordLengths();
		System.out.println(test.maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
		System.out.println(test.maxProduct(new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" }));
		System.out.println(test.maxProduct(new String[] { "a", "aa", "aaa", "aaaa" }));
	}

	public int maxProduct(String[] words) {
		int length = words.length;
		int[] value = new int[length];
		for (int i = 0; i < length; i++) {
			for (char c : words[i].toCharArray()) {
				value[i] |= 1 << (c - 'a');
			}
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			int iThWordLength = words[i].length();
			for (int j = i + 1; j < length; j++) {
				if ((value[i] & value[j]) == 0) {
					result = Math.max(result, iThWordLength * words[j].length());
				}
			}
		}
		return result;
	}

}

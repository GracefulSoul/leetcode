package gracefulsoul.problems;

public class CountTheNumberOfConsistentStrings {

	// https://leetcode.com/problems/count-the-number-of-consistent-strings/submissions/1387488828/
	public static void main(String[] args) {
		CountTheNumberOfConsistentStrings test = new CountTheNumberOfConsistentStrings();
		System.out.println(test.countConsistentStrings("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }));
		System.out.println(test.countConsistentStrings("abc", new String[] { "a", "b", "c", "ab", "ac", "bc", "abc" }));
		System.out.println(test.countConsistentStrings("cad", new String[] { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" }));
	}

	public int countConsistentStrings(String allowed, String[] words) {
		int result = words.length;
		int[] count = new int[26];
		for (char c : allowed.toCharArray()) {
			count[c - 'a']++;
		}
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (count[c - 'a'] == 0) {
					result--;
					break;
				}
			}
		}
		return result;
	}

}

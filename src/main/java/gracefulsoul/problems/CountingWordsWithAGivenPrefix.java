package gracefulsoul.problems;

public class CountingWordsWithAGivenPrefix {

	// https://leetcode.com/problems/counting-words-with-a-given-prefix/submissions/1502797735/
	public static void main(String[] args) {
		CountingWordsWithAGivenPrefix test = new CountingWordsWithAGivenPrefix();
		System.out.println(test.prefixCount(new String[] { "pay", "attention", "practice", "attend" }, "at"));
		System.out.println(test.prefixCount(new String[] { "leetcode", "win", "loops", "success" }, "code"));
	}

	public int prefixCount(String[] words, String pref) {
		int result = 0;
		for (String word : words) {
			if (word.indexOf(pref) == 0) {
				result++;
			}
		}
		return result;
	}

}

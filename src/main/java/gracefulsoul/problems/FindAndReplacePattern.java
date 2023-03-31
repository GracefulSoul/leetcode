package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {

	// https://leetcode.com/problems/find-and-replace-pattern/submissions/925311963/
	public static void main(String[] args) {
		FindAndReplacePattern test = new FindAndReplacePattern();
		System.out.println(test.findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb"));
		System.out.println(test.findAndReplacePattern(new String[] { "a", "b", "c" }, "abb"));
	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (this.match(word, pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean match(String word, String pattern) {
		for (int i = 0; i < word.length(); i++) {
			if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}

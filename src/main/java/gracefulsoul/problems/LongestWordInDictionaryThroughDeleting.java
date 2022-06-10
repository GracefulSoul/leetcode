package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

	// https://leetcode.com/submissions/detail/718807766/
	public static void main(String[] args) {
		LongestWordInDictionaryThroughDeleting test = new LongestWordInDictionaryThroughDeleting();
		System.out.println(test.findLongestWord("abpcplea", Arrays.asList(new String[] { "ale", "apple", "monkey", "plea" })));
		System.out.println(test.findLongestWord("abpcplea", Arrays.asList(new String[] { "a", "b", "c" })));
	}

	public String findLongestWord(String s, List<String> dictionary) {
		String result = "";
		for (String word : dictionary) {
			if ((word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))
					&& this.isSubsequence(word, s)) {
				result = word;
			}
		}
		return result;
	}

	private boolean isSubsequence(String str1, String str2) {
		int i = 0;
		int j = 0;
		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == str1.length();
	}

}

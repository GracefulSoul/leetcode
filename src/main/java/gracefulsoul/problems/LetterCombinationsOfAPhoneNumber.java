package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	// https://leetcode.com/submissions/detail/485817328/
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
		print(test.letterCombinations("23"));
		print(test.letterCombinations(""));
		print(test.letterCombinations("2"));
	}

	private static final String[] MAPPING = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<String>();
		if (!digits.isEmpty()) {
			this.combination("", digits, result);
		}
		return result;
	}

	private void combination(String prefix, String digits, List<String> result) {
		if (prefix.length() == digits.length()) {
			result.add(prefix);
			return;
		}
		String letters = MAPPING[(digits.charAt(prefix.length()) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			this.combination(this.addCharToString(prefix, letters.charAt(i)), digits, result);
		}
	}

	private String addCharToString(String s, Character c) {
		StringBuilder sb = new StringBuilder(s);
		sb.append(c);
		return sb.toString();
	}

	private static void print(List<String> list) {
		System.out.println(list.toString());
	}

}

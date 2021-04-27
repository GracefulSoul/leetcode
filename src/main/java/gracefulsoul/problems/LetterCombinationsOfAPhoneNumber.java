package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	// https://leetcode.com/submissions/detail/485797600/
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
		print(test.letterCombinations("23"));
		print(test.letterCombinations(""));
		print(test.letterCombinations("2"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<String>();
		if (digits.length() == 0) {
			return result;
		}
		combination("", digits, 0, result);
		return result;
	}

	private void combination(String prefix, String digits, int offset, List<String> result) {
		if (offset >= digits.length()) {
			result.add(prefix);
			return;
		}
		String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String letters = mapping[(digits.charAt(offset) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			combination(prefix + letters.charAt(i), digits, offset + 1, result);
		}
	}

	private static void print(List<String> list) {
		System.out.println(list.toString());
	}

}

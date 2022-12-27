package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	// https://leetcode.com/problems/letter-case-permutation/submissions/866187282/
	public static void main(String[] args) {
		LetterCasePermutation test = new LetterCasePermutation();
		System.out.println(test.letterCasePermutation("a1b2"));
		System.out.println(test.letterCasePermutation("3z4"));
	}

	public List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();
		this.dfs(result, s.toCharArray(), 0);
		return result;
	}

	private void dfs(List<String> result, char[] charArray, int index) {
		if (index == charArray.length) {
			result.add(new String(charArray));
		} else if (Character.isDigit(charArray[index])) {
			this.dfs(result, charArray, index + 1);
		} else {
			charArray[index] = Character.toLowerCase(charArray[index]);
			this.dfs(result, charArray, index + 1);
			charArray[index] = Character.toUpperCase(charArray[index]);
			this.dfs(result, charArray, index + 1);
		}
	}

}

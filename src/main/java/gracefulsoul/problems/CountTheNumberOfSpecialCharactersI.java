package gracefulsoul.problems;

public class CountTheNumberOfSpecialCharactersI {

	// https://leetcode.com/problems/count-the-number-of-special-characters-i/submissions/2013599411/
	public static void main(String[] args) {
		CountTheNumberOfSpecialCharactersI test = new CountTheNumberOfSpecialCharactersI();
		System.out.println(test.numberOfSpecialChars("aaAbcBC"));
		System.out.println(test.numberOfSpecialChars("abc"));
		System.out.println(test.numberOfSpecialChars("abBCab"));
	}

	public int numberOfSpecialChars(String word) {
		int[] uppers = new int[26];
		int[] lowers = new int[26];
		for (char c : word.toCharArray()) {
			if (c < 'a') {
				uppers[c - 'A']++;
			} else {
				lowers[c - 'a']++;
			}
		}
		int result = 0;
		for (int i = 0; i < 26; i++) {
			if (0 < uppers[i] && 0 < lowers[i]) {
				result++;
			}
		}
		return result;
	}

}

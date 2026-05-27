package gracefulsoul.problems;

public class CountTheNumberOfSpecialCharactersII {

	// https://leetcode.com/problems/count-the-number-of-special-characters-ii/submissions/2014606335/
	public static void main(String[] args) {
		CountTheNumberOfSpecialCharactersII test = new CountTheNumberOfSpecialCharactersII();
		System.out.println(test.numberOfSpecialChars("aaAbcBC"));
		System.out.println(test.numberOfSpecialChars("abc"));
		System.out.println(test.numberOfSpecialChars("AbBCab"));
	}

	public int numberOfSpecialChars(String word) {
		char[] charArray = word.toCharArray();
		int[] uppers = new int[26];
		int[] lowers = new int[26];
		for (int i = 0; i < 26; i++) {
			uppers[i] = -1;
			lowers[i] = -1;
		}
		for (int i = 0; i < charArray.length; i++) {
			if ('a' <= charArray[i]) {
				lowers[charArray[i] - 'a'] = i;
			} else if (uppers[charArray[i] - 'A'] == -1) {
				uppers[charArray[i] - 'A'] = i;
			}
		}
		int result = 0;
		for (int i = 0; i < 26; i++) {
			if (lowers[i] != -1 && lowers[i] < uppers[i]) {
				result++;
			}
		}
		return result;
	}

}

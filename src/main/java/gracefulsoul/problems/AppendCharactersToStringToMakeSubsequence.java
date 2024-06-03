package gracefulsoul.problems;

public class AppendCharactersToStringToMakeSubsequence {

	// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/submissions/1276178444/
	public static void main(String[] args) {
		AppendCharactersToStringToMakeSubsequence test = new AppendCharactersToStringToMakeSubsequence();
		System.out.println(test.appendCharacters("coaching", "coding"));
		System.out.println(test.appendCharacters("abcde", "a"));
		System.out.println(test.appendCharacters("z", "abcde"));
	}

	public int appendCharacters(String s, String t) {
		int j = 0;
		int sLength = s.length();
		int tLength = t.length();
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();
		for (int i = 0; i < sLength && j < tLength; i++) {
			if (sCharArray[i] == tCharArray[j]) {
				j++;
			}
		}
		return tLength - j;
	}

}

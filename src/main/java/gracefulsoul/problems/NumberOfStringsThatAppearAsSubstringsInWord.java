package gracefulsoul.problems;

public class NumberOfStringsThatAppearAsSubstringsInWord {

	// https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/submissions/2049915857/
	public static void main(String[] args) {
		NumberOfStringsThatAppearAsSubstringsInWord test = new NumberOfStringsThatAppearAsSubstringsInWord();
		System.out.println(test.numOfStrings(new String[] { "a", "abc", "bc", "d" }, "abc"));
		System.out.println(test.numOfStrings(new String[] { "a", "b", "c" }, "aaaaabbbbb"));
		System.out.println(test.numOfStrings(new String[] { "a", "a", "a" }, "ab"));
	}

	public int numOfStrings(String[] patterns, String word) {
		int result = 0;
		for (String pattern : patterns) {
			if (word.contains(pattern)) {
				result++;
			}
		}
		return result;
	}

}

package gracefulsoul.problems;

public class MakeStringASubsequenceUsingCyclicIncrements {

	// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/submissions/1470033738/
	public static void main(String[] args) {
		MakeStringASubsequenceUsingCyclicIncrements test = new MakeStringASubsequenceUsingCyclicIncrements();
		System.out.println(test.canMakeSubsequence("abc", "ad"));
		System.out.println(test.canMakeSubsequence("zc", "ad"));
		System.out.println(test.canMakeSubsequence("ab", "d"));
	}

	public boolean canMakeSubsequence(String str1, String str2) {
		int i = 0;
		int length = str2.length();
		for (char c : str1.toCharArray()) {
			if (i < length && (str2.charAt(i) - c + 26) % 26 <= 1) {
				i++;
			}
		}
		return i == length;
	}

}

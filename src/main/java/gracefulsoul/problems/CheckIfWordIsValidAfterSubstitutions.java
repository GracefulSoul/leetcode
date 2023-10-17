package gracefulsoul.problems;

public class CheckIfWordIsValidAfterSubstitutions {

	// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/submissions/1076584965/
	public static void main(String[] args) {
		CheckIfWordIsValidAfterSubstitutions test = new CheckIfWordIsValidAfterSubstitutions();
		System.out.println(test.isValid("aabcbc"));
		System.out.println(test.isValid("abcabcababcc"));
		System.out.println(test.isValid("abccba"));
	}

	public boolean isValid(String s) {
		String abc = "abc";
		while (s.contains(abc)) {
			s = s.replace(abc, "");
		}
		return s.isEmpty();
	}

}

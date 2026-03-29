package gracefulsoul.problems;

public class CheckIfStringsCanBeMadeEqualWithOperationsI {

	// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/submissions/1962326915/
	public static void main(String[] args) {
		CheckIfStringsCanBeMadeEqualWithOperationsI test = new CheckIfStringsCanBeMadeEqualWithOperationsI();
		System.out.println(test.canBeEqual("abcd", "cdab"));
		System.out.println(test.canBeEqual("abcd", "dacb"));
	}

	public boolean canBeEqual(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		return (
			(s1CharArray[0] == s2CharArray[0] && s1CharArray[2] == s2CharArray[2]) ||
			(s1CharArray[0] == s2CharArray[2] && s1CharArray[2] == s2CharArray[0]))
		&& (
			(s1CharArray[1] == s2CharArray[1] && s1CharArray[3] == s2CharArray[3]) ||
			(s1CharArray[1] == s2CharArray[3] && s1CharArray[3] == s2CharArray[1])
		);
	}

}

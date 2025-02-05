package gracefulsoul.problems;

public class CheckIfOneStringSwapCanMakeStringsEqual {

	// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/submissions/1532178071/
	public static void main(String[] args) {
		CheckIfOneStringSwapCanMakeStringsEqual test = new CheckIfOneStringSwapCanMakeStringsEqual();
		System.out.println(test.areAlmostEqual("bank", "kanb"));
		System.out.println(test.areAlmostEqual("attack", "defend"));
		System.out.println(test.areAlmostEqual("kelb", "kelb"));
	}

	public boolean areAlmostEqual(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		int i = -1;
		int j = -1;
		int count = 0;
		for (int k = 0; k < s1CharArray.length; k++) {
			if (s1CharArray[k] != s2CharArray[k]) {
				count++;
				if (i == -1) {
					i = k;
				} else if (j == -1) {
					j = k;
				}
			}
		}
		return count == 0 || (count == 2 && s1CharArray[i] == s2CharArray[j] && s1CharArray[j] == s2CharArray[i]);
	}

}

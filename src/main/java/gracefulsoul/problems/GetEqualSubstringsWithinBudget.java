package gracefulsoul.problems;

public class GetEqualSubstringsWithinBudget {

	// https://leetcode.com/problems/get-equal-substrings-within-budget/submissions/1270480663/
	public static void main(String[] args) {
		GetEqualSubstringsWithinBudget test = new GetEqualSubstringsWithinBudget();
		System.out.println(test.equalSubstring("abcd", "bcdf", 3));
		System.out.println(test.equalSubstring("abcd", "cdef", 3));
		System.out.println(test.equalSubstring("abcd", "acde", 0));
	}

	public int equalSubstring(String s, String t, int maxCost) {
		char[] sCharArray = s.toCharArray();
		char[] tCharArrat = t.toCharArray();
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			maxCost -= Math.abs(sCharArray[j] - tCharArrat[j++]);
			if (maxCost < 0) {
				maxCost += Math.abs(sCharArray[i] - tCharArrat[i++]);
			}
		}
		return j - i;
	}

}

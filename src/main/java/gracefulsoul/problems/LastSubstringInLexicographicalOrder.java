package gracefulsoul.problems;

public class LastSubstringInLexicographicalOrder {

	// https://leetcode.com/problems/last-substring-in-lexicographical-order/submissions/1361185608/
	public static void main(String[] args) {
		LastSubstringInLexicographicalOrder test = new LastSubstringInLexicographicalOrder();
		System.out.println(test.lastSubstring("abab"));
		System.out.println(test.lastSubstring("leetcode"));
	}

	public String lastSubstring(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int i = 0;
		int j = 1;
		int k = 0;
		while (j + k < length) {
			if (charArray[i + k] == charArray[j + k]) {
				k++;
			} else {
				if (charArray[i + k] > charArray[j + k]) {
					j += k + 1;
				} else {
					i = Math.max(i + k + 1, j);
					j = i + 1;
				}
				k = 0;
			}
		}
		return s.substring(i);
	}

}

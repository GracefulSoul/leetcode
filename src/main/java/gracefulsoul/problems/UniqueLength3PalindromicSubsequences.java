package gracefulsoul.problems;

public class UniqueLength3PalindromicSubsequences {

	// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/submissions/1098575584/
	public static void main(String[] args) {
		UniqueLength3PalindromicSubsequences test = new UniqueLength3PalindromicSubsequences();
		System.out.println(test.countPalindromicSubsequence("aabca"));
		System.out.println(test.countPalindromicSubsequence("adc"));
		System.out.println(test.countPalindromicSubsequence("bbcbaba"));
	}

	public int countPalindromicSubsequence(String s) {
		int result = 0;
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		for (char c = 'a'; c <= 'z'; c++) {
			int start = -1;
			int end = -1;
			for (int i = 0; i < length; i++) {
				if (charArray[i] == c) {
					if (start == -1) {
						start = i;
					}
					end = i;
				}
			}
			if (start != -1 && end != -1 && end - start >= 2) {
				boolean[] seen = new boolean[26];
				for (int i = start + 1; i < end; i++) {
					int num = charArray[i] - 'a';
					if (!seen[num]) {
						seen[num] = true;
						result++;
					}
				}
			}
		}
		return result;
	}

}

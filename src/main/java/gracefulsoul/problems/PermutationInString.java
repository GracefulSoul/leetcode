package gracefulsoul.problems;

public class PermutationInString {

	// https://leetcode.com/submissions/detail/745963928/
	public static void main(String[] args) {
		PermutationInString test = new PermutationInString();
		System.out.println(test.checkInclusion("ab", "eidbaooo"));
		System.out.println(test.checkInclusion("ab", "eidboaoo"));
	}

	public boolean checkInclusion(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		int start = 0;
		int end = 0;
		int[] count = new int[26];
		for (char c : s1CharArray) {
			count[c - 'a']++;
		}
		while (end < s2CharArray.length) {
			char curr = s2CharArray[end++];
			count[curr - 'a']--;
			while (count[curr - 'a'] < 0 && start < end) {
				count[s2CharArray[start++] - 'a']++;
			}
			if (end - start == s1CharArray.length) {
				return true;
			}
		}
		return false;
	}

}

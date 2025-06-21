package gracefulsoul.problems;

public class MinimumDeletionsToMakeStringKSpecial {

	// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/submissions/1671484565/
	public static void main(String[] args) {
		MinimumDeletionsToMakeStringKSpecial test = new MinimumDeletionsToMakeStringKSpecial();
		System.out.println(test.minimumDeletions("aabcaba", 0));
		System.out.println(test.minimumDeletions("dabdcbdcdcd", 2));
		System.out.println(test.minimumDeletions("aaabaaa", 2));
	}

	public int minimumDeletions(String word, int k) {
		int result = 100000;
		int[] counts = new int[26];
		for (char c : word.toCharArray()) {
			counts[c - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (counts[i] == 0) {
				continue;
			}
			int count = 0;
			for (int j = 0; j < 26; j++) {
				if (i == j || counts[j] == 0) {
					continue;
				}
				count += counts[j] < counts[i] ? counts[j] : Math.max(0, counts[j] - (counts[i] + k));
			}
			result = Math.min(result, count);
		}
		return result;
	}

}

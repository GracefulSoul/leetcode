package gracefulsoul.problems;

public class LexicographicallySmallestPalindromicPermutationGreaterThanTarget {

	// https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/submissions/2122833300/
	public static void main(String[] args) {
		LexicographicallySmallestPalindromicPermutationGreaterThanTarget test = new LexicographicallySmallestPalindromicPermutationGreaterThanTarget();
		System.out.println(test.lexPalindromicPermutation("baba", "abba"));
		System.out.println(test.lexPalindromicPermutation("baba", "bbaa"));
		System.out.println(test.lexPalindromicPermutation("abc", "abb"));
		System.out.println(test.lexPalindromicPermutation("aac", "abb"));
	}

	public String lexPalindromicPermutation(String s, String target) {
		int[] counts = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
		}
		char c = 0;
		for (int i = 0; i < 26; i++) {
			if (counts[i] % 2 != 0) {
				if (c != 0) {
					return "";
				}
				c = (char) ('a' + i);
				counts[i]--;
			}
		}
		int half = s.length() / 2;
		for (int i = 0; i < half; i++) {
			counts[target.charAt(i) - 'a'] -= 2;
		}
		if (this.check(counts)) {
			String head = target.substring(0, half);
			String rev = new StringBuilder(head).reverse().toString();
			String tail = "";
			if (c != 0)
				tail += c;
			tail += rev;
			if (tail.compareTo(target.substring(half)) > 0)
				return head + tail;
		}

		for (int i = half - 1; i >= 0; i--) {
			int index = target.charAt(i) - 'a';
			counts[index] += 2;
			if (!this.check(counts)) {
				continue;
			}
			for (int j = index + 1; j < 26; j++) {
				if (counts[j] == 0) {
					continue;
				}
				counts[j] -= 2;
				StringBuilder sb = new StringBuilder(target.substring(0, i + 1));
				sb.setCharAt(i, (char) ('a' + j));
				for (int k = 0; k < 26; k++) {
					int count = counts[k] / 2;
					for (int m = 0; m < count; m++) {
						sb.append((char) ('a' + k));
					}
				}
				String reverse = new StringBuilder(sb).reverse().toString();
				if (c != 0) {
					sb.append(c);
				}
				sb.append(reverse);
				return sb.toString();
			}
		}
		return "";
	}

	private boolean check(int[] counts) {
		for (int count : counts) {
			if (count < 0) {
				return false;
			}
		}
		return true;
	}

}

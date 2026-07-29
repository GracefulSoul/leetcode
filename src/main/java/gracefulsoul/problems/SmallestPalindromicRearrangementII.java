package gracefulsoul.problems;

public class SmallestPalindromicRearrangementII {

	// https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/submissions/2086265008/
	public static void main(String[] args) {
		SmallestPalindromicRearrangementII test = new SmallestPalindromicRearrangementII();
		System.out.println(test.smallestPalindrome("abba", 2));
		System.out.println(test.smallestPalindrome("aa", 2));
		System.out.println(test.smallestPalindrome("bacab", 1));
	}

	private static final long MAX = 1000001;

	public String smallestPalindrome(String s, int k) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		char mid = 0;
		for (int i = 0; i < 26; i++) {
			if (counts[i] % 2 == 1) {
				mid = (char) ('a' + i);
				counts[i]--;
				break;
			}
		}
		int[] halfCounts = new int[26];
		int halfLength = 0;
		for (int i = 0; i < 26; i++) {
			halfCounts[i] = counts[i] / 2;
			halfLength += halfCounts[i];
		}
		if (this.getPermutations(halfCounts) < k) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < halfLength; i++) {
			for (int c = 0; c < 26; c++) {
				if (halfCounts[c] > 0) {
					halfCounts[c]--;
					long permutations = this.getPermutations(halfCounts);
					if (k <= permutations) {
						sb.append((char) ('a' + c));
						break;
					} else {
						k -= permutations;
						halfCounts[c]++;
					}
				}
			}
		}
		String str = sb.toString();
		String reverse = new StringBuilder(str).reverse().toString();
		if (mid == 0) {
			return str + reverse;
		} else {
			return str + mid + reverse;
		}
	}

	private long getPermutations(int[] counts) {
		int total = 0;
		for (int count : counts) {
			total += count;
		}
		long result = 1;
		for (int count : counts) {
			result *= this.combination(total, count);
			if (result >= MAX) {
				return MAX;
			}
			total -= count;
		}
		return result;
	}

	private long combination(int n, int k) {
		if (n < k) {
			return 0;
		}
		if (n - k < k) {
			k = n - k;
		}
		long result = 1;
		for (int i = 1; i <= k; i++) {
			result = (result * (n - i + 1)) / i;
			if (MAX <= result) {
				return MAX;
			}
		}
		return result;
	}

}

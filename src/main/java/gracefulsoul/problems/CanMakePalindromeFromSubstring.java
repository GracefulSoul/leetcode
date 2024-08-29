package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring {

	// https://leetcode.com/problems/can-make-palindrome-from-substring/submissions/1372015236/
	public static void main(String[] args) {
		CanMakePalindromeFromSubstring test = new CanMakePalindromeFromSubstring();
		System.out.println(test.canMakePaliQueries("abcda", new int[][] {
			{ 3, 3, 0 },
			{ 1, 2, 0 },
			{ 0, 3, 1 },
			{ 0, 3, 2 },
			{ 0, 4, 1 }
		}));
		System.out.println(test.canMakePaliQueries("lyb", new int[][] {
			{ 0, 1, 0 },
			{ 2, 2, 1 }
		}));
	}

	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		int[] counts = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			counts[i + 1] = counts[i] ^ (1 << (s.charAt(i) - 'a'));
		}
		List<Boolean> result = new ArrayList<>();
		for (int[] query : queries) {
			result.add(((((query[1] - query[0]) % 2) + Integer.bitCount(counts[query[1] + 1] ^ counts[query[0]])) / 2) <= query[2]);
		}
		return result;
	}

}

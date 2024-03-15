package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateSubstring {

	// https://leetcode.com/problems/longest-duplicate-substring/submissions/1203953560/
	public static void main(String[] args) {
		LongestDuplicateSubstring test = new LongestDuplicateSubstring();
		System.out.println(test.longestDupSubstring("banana"));
		System.out.println(test.longestDupSubstring("abcd"));
	}

	public String longestDupSubstring(String s) {
		String result = "";
		int left = 1;
		int right = s.length() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			String duplicateSubstring = this.getDuplicateSubstring(mid, s);
			if (duplicateSubstring != null) {
				result = duplicateSubstring;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	private String getDuplicateSubstring(int size, String s) {
		long hash = this.toHash(s.substring(0, size));
		Set<Long> set = new HashSet<>();
		set.add(hash);
		long pow = 1;
		for (int i = 1; i < size; i++) {
			pow *= 27;
		}
		for (int i = size; i < s.length(); i++) {
			hash = this.getNextHash(pow, hash, s.charAt(i - size), s.charAt(i));
			if (!set.add(hash)) {
				return s.substring(i - size + 1, i + 1);
			}
		}
		return null;
	}

	private long toHash(String s) {
		long hash = 0;
		long pow = 1;
		for (int k = s.length(); k >= 1; k--) {
			hash += (s.charAt(k - 1) - 'a' + 1) * pow;
			pow *= 27;
		}
		return hash;
	}

	private long getNextHash(long pow, long hash, char left, char right) {
		return (hash - (left - 'a' + 1) * pow) * 27 + (right - 'a' + 1);
	}

}

package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindTheClosestPalindrome {

	// https://leetcode.com/submissions/detail/743413685/
	public static void main(String[] args) {
		FindTheClosestPalindrome test = new FindTheClosestPalindrome();
		System.out.println(test.nearestPalindromic("123"));
		System.out.println(test.nearestPalindromic("1"));
	}

	public String nearestPalindromic(String n) {
		int length = n.length();
		int index = length % 2 == 0 ? (length / 2) - 1 : length / 2;
		long start = Long.parseLong(n.substring(0, index + 1));

		List<Long> candidates = new ArrayList<>();
		candidates.add(this.getPalindrome(start, length % 2 == 0));
		candidates.add(this.getPalindrome(start + 1, length % 2 == 0));
		candidates.add(this.getPalindrome(start - 1, length % 2 == 0));
		candidates.add((long) Math.pow(10, length - 1) - 1);
		candidates.add((long) Math.pow(10, length) + 1);

		long diff = Long.MAX_VALUE;
		long result = 0;
		long num = Long.parseLong(n);
		for (long candidate : candidates) {
			if (candidate == num) {
				continue;
			}
			if (Math.abs(candidate - num) < diff) {
				diff = Math.abs(candidate - num);
				result = candidate;
			} else if (Math.abs(candidate - num) == diff) {
				result = Math.min(result, candidate);
			}
		}
		return String.valueOf(result);
	}

	private long getPalindrome(long start, boolean even) {
		long result = start;
		if (!even) {
			start /= 10;
		}
		while (start > 0) {
			result = result * 10 + start % 10;
			start /= 10;
		}
		return result;
	}

}

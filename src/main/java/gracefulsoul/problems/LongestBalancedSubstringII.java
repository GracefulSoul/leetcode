package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubstringII {

	// https://leetcode.com/problems/longest-balanced-substring-ii/submissions/1917898556/
	public static void main(String[] args) {
		LongestBalancedSubstringII test = new LongestBalancedSubstringII();
		System.out.println(test.longestBalanced("abbac"));
		System.out.println(test.longestBalanced("aabcc"));
		System.out.println(test.longestBalanced("aba"));
	}

	public int longestBalanced(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int result = 0;
		for (int i = 0; i < length;) {
			int start = i++;
			while (i < length && charArray[i] == charArray[i - 1]) {
				i++;
			}
			result = Math.max(result, i - start);
		}
		result = Math.max(result, this.getMax(s, length, 'b', 'c'));
		result = Math.max(result, this.getMax(s, length, 'a', 'c'));
		result = Math.max(result, this.getMax(s, length, 'a', 'b'));
		Map<Long, Integer> map = new HashMap<>(length * 2 + 1);
		map.put(this.getKey(0, 0), -1);
		int countA = 0;
		int countB = 0;
		int countC = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				countA++;
			} else if (c == 'b') {
				countB++;
			} else if (c == 'c') {
				countC++;
			}
			long key = this.getKey(countA - countB, countB - countC);
			Integer num = map.get(key);
			if (num != null) {
				result = Math.max(result, i - num);
			} else {
				map.put(key, i);
			}
		}
		return result;
	}

	private long getKey(int d1, int d2) {
		return (((long) d1) << 32) ^ (d2 & 0xffffffffL);
	}

	private int getMax(String s, int n, char x, char y) {
		int max = 0;
		int[] first = new int[(2 * n) + 1];
		Arrays.fill(first, Integer.MAX_VALUE);
		int[] touched = new int[first.length];
		int count = 0;
		for (int i = 0; i < n; i++) {
			first[n] = i - 1;
			touched[count++] = n;
			int d = 0;
			while (i < n) {
				char c = s.charAt(i);
				if (c != x && c != y) {
					break;
				}
				d += c == x ? 1 : -1;
				int j = d + n;
				if (first[j] != Integer.MAX_VALUE) {
					max = Math.max(max, i - first[j]);
				} else {
					first[j] = i;
					touched[count++] = j;
				}
				i++;
			}
			for (int k = 0; k < count; k++) {
				first[touched[k]] = Integer.MAX_VALUE;
			}
			count = 0;
		}
		return max;
	}

}

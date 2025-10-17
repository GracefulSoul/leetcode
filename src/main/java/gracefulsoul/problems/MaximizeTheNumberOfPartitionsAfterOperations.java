package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MaximizeTheNumberOfPartitionsAfterOperations {

	// https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations/submissions/1804172448/
	public static void main(String[] args) {
		MaximizeTheNumberOfPartitionsAfterOperations test = new MaximizeTheNumberOfPartitionsAfterOperations();
		System.out.println(test.maxPartitionsAfterOperations("accca", 2));
		System.out.println(test.maxPartitionsAfterOperations("aabaab", 3));
		System.out.println(test.maxPartitionsAfterOperations("xxyz", 1));
	}

	private Map<Long, Integer> map;
	private String s;
	private int k;

	public int maxPartitionsAfterOperations(String s, int k) {
		this.map = new HashMap<>();
		this.s = s;
		this.k = k;
		return this.dp(0, 0, true) + 1;
	}

	private int dp(int i, int curr, boolean canChange) {
		long key = ((long) i << 27) | ((long) curr << 1) | (canChange ? 1 : 0);
		if (this.map.containsKey(key)) {
			return this.map.get(key);
		} else if (i == this.s.length()) {
			return 0;
		} else {
			int index = this.s.charAt(i) - 'a';
			int updated = curr | (1 << index);
			int result;
			if (this.k < Integer.bitCount(updated)) {
				result = 1 + this.dp(i + 1, 1 << index, canChange);
			} else {
				result = this.dp(i + 1, updated, canChange);
			}
			if (canChange) {
				for (int j = 0; j < 26; j++) {
					int next = curr | (1 << j);
					if (this.k < Integer.bitCount(next)) {
						result = Math.max(result, 1 + this.dp(i + 1, 1 << j, false));
					} else {
						result = Math.max(result, this.dp(i + 1, next, false));
					}
				}
			}
			this.map.put(key, result);
			return result;
		}
	}

}

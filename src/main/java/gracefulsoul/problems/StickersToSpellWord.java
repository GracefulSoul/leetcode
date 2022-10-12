package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class StickersToSpellWord {

	// https://leetcode.com/submissions/detail/820812624/
	public static void main(String[] args) {
		StickersToSpellWord test = new StickersToSpellWord();
		System.out.println(test.minStickers(new String[] { "with", "example", "science" }, "thehat"));
		System.out.println(test.minStickers(new String[] { "notice", "possible" }, "basicbasic"));
	}

	public int minStickers(String[] stickers, String target) {
		int length = stickers.length;
		int[][] dp = new int[length][26];
		for (int i = 0; i < length; i++) {
			for (char c : stickers[i].toCharArray()) {
				dp[i][c - 'a']++;
			}
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("", 0);
		return this.recursive(dp, target, map);
	}

	private int recursive(int[][] dp, String target, Map<String, Integer> map) {
		if (map.containsKey(target)) {
			return map.get(target);
		}
		int min = Integer.MAX_VALUE;
		int length = dp.length;
		int[] str = new int[26];
		for (char c : target.toCharArray()) {
			str[c - 'a']++;
		}
		for (int i = 0; i < length; i++) {
			if (dp[i][target.charAt(0) - 'a'] == 0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 26; j++) {
				if (str[j] > 0) {
					for (int k = 0; k < Math.max(0, str[j] - dp[i][j]); k++) {
						sb.append((char) (j + 'a'));
					}
				}
			}
			int temp = this.recursive(dp, sb.toString(), map);
			if (temp != -1) {
				min = Math.min(min, 1 + temp);
			}
		}
		map.put(target, min == Integer.MAX_VALUE ? -1 : min);
		return map.get(target);
	}

}

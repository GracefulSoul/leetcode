package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	// https://leetcode.com/submissions/detail/478726995/
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(test.lengthOfLongestSubstring("bbbbb"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c) + 1);
			}
			map.put(c, i);
			result = Math.max(result, i - j + 1);
		}
		return result;
	}

}

package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {

	// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/submissions/1391539033/
	public static void main(String[] args) {
		FindTheLongestSubstringContainingVowelsInEvenCounts test = new FindTheLongestSubstringContainingVowelsInEvenCounts();
		System.out.println(test.findTheLongestSubstring("eleetminicoworoep"));
		System.out.println(test.findTheLongestSubstring("leetcodeisgreat"));
		System.out.println(test.findTheLongestSubstring("bcbcbc"));
	}

	public int findTheLongestSubstring(String s) {
		int result = 0;
		int curr = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < s.length(); i++) {
			curr ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
			map.putIfAbsent(curr, i);
			result = Math.max(result, i - map.get(curr));
		}
		return result;
	}

}

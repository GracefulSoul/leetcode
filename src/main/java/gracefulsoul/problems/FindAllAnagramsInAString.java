package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

	// https://leetcode.com/submissions/detail/670078444/
	public static void main(String[] args) {
		FindAllAnagramsInAString test = new FindAllAnagramsInAString();
		System.out.println(test.findAnagrams("cbaebabacd", "abc"));
		System.out.println(test.findAnagrams("abab", "ab"));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (p.length() > s.length()) {
			return result;
		}
		int[] countP = new int[26];
		for (int idx = 0; idx < p.length(); idx++) {
			countP[p.charAt(idx) - 97]++;
		}
		int[] countS = new int[26];
		int idx = 0;
		int i = 0;
		while (idx < p.length() && idx < s.length()) {
			countS[s.charAt(idx++) - 97]++;
		}
		while (idx <= s.length()) {
			int j = 0;
			while (j < 26 && countP[j] == countS[j]) {
				j++;
			}
			if (j == 26) {
				result.add(i);
			}
			countS[s.charAt(i) - 97]--;
			i++;
			if (idx != s.length()) {
				countS[s.charAt(idx) - 97]++;
			}
			idx++;
		}
		return result;
	}

}

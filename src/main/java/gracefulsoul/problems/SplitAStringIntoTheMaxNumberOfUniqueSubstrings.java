package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

	// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/submissions/1429135011/
	public static void main(String[] args) {
		SplitAStringIntoTheMaxNumberOfUniqueSubstrings test = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
		System.out.println(test.maxUniqueSplit("ababccc"));
		System.out.println(test.maxUniqueSplit("aba"));
		System.out.println(test.maxUniqueSplit("aa"));
	}

	public int maxUniqueSplit(String s) {
		return this.dfs(s, 0, new HashSet<>());
	}

	private int dfs(String s, int i, Set<String> seen) {
		if (i == s.length()) {
			return 0;
		} else {
			int max = 0;
			for (int end = i + 1; end <= s.length(); end++) {
				String substring = s.substring(i, end);
				if (!seen.contains(substring)) {
					seen.add(substring);
					max = Math.max(max, 1 + this.dfs(s, end, seen));
					seen.remove(substring);
				}
			}
			return max;
		}
	}

}

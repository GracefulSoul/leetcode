package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {

	// https://leetcode.com/problems/groups-of-special-equivalent-strings/submissions/927833927/
	public static void main(String[] args) {
		GroupsOfSpecialEquivalentStrings test = new GroupsOfSpecialEquivalentStrings();
		System.out.println(test.numSpecialEquivGroups(new String[] { "abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx" }));
		System.out.println(test.numSpecialEquivGroups(new String[] { "abc", "acb", "bac", "bca", "cab", "cba" }));
	}

	public int numSpecialEquivGroups(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			int length = word.length();
			char[] even = new char[(length + 1) / 2];
			char[] odd = new char[length / 2];
			for (int i = 0; i < length; i++) {
				if (i % 2 == 0) {
					even[i / 2] = word.charAt(i);
				} else {
					odd[i / 2] = word.charAt(i);
				}
			}
			Arrays.sort(even);
			Arrays.sort(odd);
			set.add(Arrays.toString(odd) + Arrays.toString(even));
		}
		return set.size();
	}

}

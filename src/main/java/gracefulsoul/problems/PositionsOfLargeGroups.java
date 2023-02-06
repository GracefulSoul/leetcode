package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

	// https://leetcode.com/problems/positions-of-large-groups/submissions/892563981/
	public static void main(String[] args) {
		PositionsOfLargeGroups test = new PositionsOfLargeGroups();
		System.out.println(test.largeGroupPositions("abbxxxxzzy"));
		System.out.println(test.largeGroupPositions("abc"));
		System.out.println(test.largeGroupPositions("abcdddeeeeaabbbcd"));
	}

	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> list = new ArrayList<>();
		char[] charArray = s.toCharArray();
		int start = 0;
		for (int idx = 1; idx < s.length(); idx++) {
			List<Integer> temp = new ArrayList<>();
			while (idx < s.length() && charArray[idx - 1] == charArray[idx]) {
				idx++;
			}
			if (idx - start >= 3) {
				temp.add(start);
				temp.add(idx - 1);
				list.add(temp);
			}
			start = idx;
		}
		return list;
	}

}

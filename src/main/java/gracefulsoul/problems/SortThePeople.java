package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class SortThePeople {

	// https://leetcode.com/problems/sort-the-people/submissions/1329324966/
	public static void main(String[] args) {
		SortThePeople test = new SortThePeople();
		PrintUtil.print(test.sortPeople(new String[] { "Mary", "John", "Emma" }, new int[] { 180, 165, 170 }));
		PrintUtil.print(test.sortPeople(new String[] { "Alice", "Bob", "Bob" }, new int[] { 155, 185, 150 }));
	}

	public String[] sortPeople(String[] names, int[] heights) {
		int length = names.length;
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(heights[i], names[i]);
		}
		Arrays.sort(heights);
		String[] result = new String[length];
		for (int index = 0, i = length - 1; i >= 0; i--, index++) {
			result[index] = map.get(heights[i]);
		}
		return result;
	}

}

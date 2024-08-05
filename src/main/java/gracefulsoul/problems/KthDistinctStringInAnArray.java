package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {

	// https://leetcode.com/problems/kth-distinct-string-in-an-array/submissions/1345185021/
	public static void main(String[] args) {
		KthDistinctStringInAnArray test = new KthDistinctStringInAnArray();
		System.out.println(test.kthDistinct(new String[] { "d", "b", "c", "b", "c", "a" }, 2));
		System.out.println(test.kthDistinct(new String[] { "aaa", "aa", "a" }, 1));
		System.out.println(test.kthDistinct(new String[] { "a", "b", "a" }, 3));
	}

	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : arr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (String s : arr) {
			if (map.get(s) == 1 && --k == 0) {
				return s;
			}
		}
		return "";
	}

}

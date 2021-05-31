package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	// https://leetcode.com/submissions/detail/500813553/
	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		print(test.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		print(test.groupAnagrams(new String[] { "" }));
		print(test.groupAnagrams(new String[] { "a" }));
	}

	private static final char A = 'a';

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> result = new HashMap<>();
		for (String str : strs) {
			char[] chars = new char[26];
			for (char chr : str.toCharArray()) {
				chars[chr - A]++;
			}
			String key = String.valueOf(chars);
			if (!result.containsKey(key)) {
				result.put(key, new ArrayList<>());
			}
			result.get(key).add(str);
		}
		return new ArrayList<>(result.values());
	}

	private static void print(List<List<String>> list) {
		System.out.println(list.toString());
	}

}

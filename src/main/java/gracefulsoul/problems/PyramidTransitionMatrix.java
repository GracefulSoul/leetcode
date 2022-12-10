package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PyramidTransitionMatrix {

	// https://leetcode.com/problems/pyramid-transition-matrix/submissions/856891528/
	public static void main(String[] args) {
		PyramidTransitionMatrix test = new PyramidTransitionMatrix();
		System.out.println(test.pyramidTransition("BCD", Arrays.asList("BCC", "CDE", "CEA", "FFF")));
		System.out.println(test.pyramidTransition("AAAA", Arrays.asList("AAB", "AAC", "BCD", "BBE", "DEF")));
	}

	public boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String, List<Character>> map = new HashMap<>();
		for (String s : allowed) {
			String key = s.substring(0, 2);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(s.charAt(2));
		}
		return this.dfs(map, bottom + '&', new HashSet<>());
	}

	private boolean dfs(Map<String, List<Character>> map, String s, Set<String> set) {
		if (s.length() == 1) {
			return true;
		}
		if (set.contains(s)) {
			return false;
		}
		String prefix = s.substring(0, 2);
		if (prefix.charAt(1) == '&') {
			return this.dfs(map, s.substring(2) + '&', set);
		}
		for (char c : map.getOrDefault(prefix, new ArrayList<>())) {
			if (this.dfs(map, s.substring(1) + c, set)) {
				return true;
			}
		}
		set.add(s);
		return false;
	}

}

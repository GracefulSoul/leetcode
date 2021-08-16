package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {

	// https://leetcode.com/submissions/detail/539209014/
	public static void main(String[] args) {
		WordLadderII test = new WordLadderII();
		System.out.println(test.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(test.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		List<List<String>> result = new ArrayList<>();
		if (!wordSet.contains(endWord)) {
			return result;
		}
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		this.findLadders(beginWord, endWord, this.getChildren(beginWord, endWord, wordSet), result, path);
		return result;

	}

	private void findLadders(String beginWord, String endWord, Map<String, List<String>> child, List<List<String>> result, List<String> path) {
		if (beginWord.equals(endWord)) {
			result.add(new ArrayList<>(path));
		}
		if (!child.containsKey(beginWord)) {
			return;
		}
		for (String next : child.get(beginWord)) {
			path.add(next);
			findLadders(next, endWord, child, result, path);
			path.remove(path.size() - 1);
		}
	}

	private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> wordSet) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();
		Set<String> visited = new HashSet<>();
		start.add(beginWord);
		end.add(endWord);
		boolean found = false;
		boolean isBackward = false;
		while (!start.isEmpty() && !found) {
			if (start.size() > end.size()) {
				Set<String> tem = start;
				start = end;
				end = tem;
				isBackward = !isBackward;
			}
			Set<String> set = new HashSet<>();
			for (String cur : start) {
				visited.add(cur);
				for (String next : this.getNext(cur, wordSet)) {
					if (visited.contains(next) || start.contains(next)) {
						continue;
					}
					if (end.contains(next)) {
						found = true;
					}
					set.add(next);
					String parent = isBackward ? next : cur;
					String child = isBackward ? cur : next;
					if (!map.containsKey(parent)) {
						map.put(parent, new ArrayList<>());
					}
					map.get(parent).add(child);

				}
			}
			start = set;
		}
		return map;

	}

	private List<String> getNext(String cur, Set<String> wordSet) {
		List<String> result = new ArrayList<>();
		char[] charArr = cur.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char temp = charArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == temp) {
					continue;
				}
				charArr[i] = c;
				String next = new String(charArr);
				if (wordSet.contains(next)) {
					result.add(next);
				}
			}
			charArr[i] = temp;
		}
		return result;
	}

}

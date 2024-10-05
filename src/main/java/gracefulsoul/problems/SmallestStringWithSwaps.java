package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestStringWithSwaps {

	// https://leetcode.com/problems/smallest-string-with-swaps/submissions/1412100428/
	public static void main(String[] args) {
		SmallestStringWithSwaps test = new SmallestStringWithSwaps();
		System.out.println(test.smallestStringWithSwaps("dcab", Arrays.asList(
			Arrays.asList(0, 3),
			Arrays.asList(1, 2)
		)));
		System.out.println(test.smallestStringWithSwaps("dcab", Arrays.asList(
			Arrays.asList(0, 3),
			Arrays.asList(1, 2),
			Arrays.asList(0, 2)
		)));
		System.out.println(test.smallestStringWithSwaps("cba", Arrays.asList(
			Arrays.asList(0, 1),
			Arrays.asList(1, 2)
		)));
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[] parent = new int[length];
		Map<Integer, Queue<Character>> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			parent[i] = i;
		}
		for (List<Integer> pair : pairs) {
			this.union(parent, pair.get(0), pair.get(1));
		}
		for (int i = 0; i < length; i++) {
			map.computeIfAbsent(this.find(parent, i), k -> new PriorityQueue<>());
			map.get(parent[i]).offer(charArray[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(map.get(parent[i]).poll());
		}
		return sb.toString();
	}

	private void union(int[] parent, int i, int j) {
		int pi = this.find(parent, i);
		int pj = this.find(parent, j);
		if (pi > pj) {
			parent[pi] = pj;
		} else {
			parent[pj] = pi;
		}
	}

	private int find(int[] parent, int i) {
		if (i != parent[i]) {
			parent[i] = this.find(parent, parent[i]);
		}
		return parent[i];
	}

}

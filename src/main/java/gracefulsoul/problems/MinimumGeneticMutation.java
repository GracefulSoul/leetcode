package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation {

	// https://leetcode.com/submissions/detail/667543851/
	public static void main(String[] args) {
		MinimumGeneticMutation test = new MinimumGeneticMutation();
		System.out.println(test.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
		System.out.println(test.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA", "AACCGCTA", "AAACGGTA" }));
		System.out.println(test.minMutation("AAAAACCC", "AACCCCCC", new String[] { "AAAACCCC", "AAACCCCC", "AACCCCCC" }));
	}

	public int minMutation(String start, String end, String[] bank) {
		return this.dfs(start, end, bank, new HashSet<>());
	}

	private int dfs(String start, String end, String[] bank, Set<String> visited) {
		if (start.equals(end)) {
			return 0;
		}
		int min = 11;
		for (String gene : bank) {
			int diff = 0;
			for (int idx = 0; idx < 8; idx++) {
				if (start.charAt(idx) != gene.charAt(idx)) {
					diff++;
				}
				if (diff > 1) {
					break;
				}
			}
			if (diff == 1 && !visited.contains(gene)) {
				visited.add(gene);
				int h = this.dfs(gene, end, bank, visited);
				if (h >= 0) {
					min = Math.min(min, h + 1);
				}
				visited.remove(gene);
			}
		}
		return min == 11 ? -1 : min;
	}

}

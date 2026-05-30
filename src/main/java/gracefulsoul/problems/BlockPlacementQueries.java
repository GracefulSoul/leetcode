package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import gracefulsoul.object.tree.SegmentTree;

public class BlockPlacementQueries {

	// https://leetcode.com/problems/block-placement-queries/submissions/2016973198/
	public static void main(String[] args) {
		BlockPlacementQueries test = new BlockPlacementQueries();
		System.out.println(test.getResults(new int[][] {
			{ 1, 2 },
			{ 2, 3, 3 },
			{ 2, 3, 1 },
			{ 2, 2, 2 }
		}));
		System.out.println(test.getResults(new int[][] {
			{ 1, 7 },
			{ 2, 7, 6 },
			{ 1, 2 },
			{ 2, 7, 5 },
			{ 2, 7, 6 }
		}));
	}

	public List<Boolean> getResults(int[][] queries) {
		int limit = 50000;
		SegmentTree tree = new SegmentTree(limit);
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		set.add(limit);
		tree.update(0, limit);
		List<Boolean> result = new ArrayList<>();
		for (int[] query : queries) {
			if (query[0] == 1) {
				int prev = set.floor(query[1]);
				int next = set.ceiling(query[1]);
				set.add(query[1]);
				tree.update(query[1], next - query[1]);
				tree.update(prev, query[1] - prev);
			} else {
				result.add(tree.query(0, query[1] - query[2]) >= query[2]);
			}
		}
		return result;
	}

}

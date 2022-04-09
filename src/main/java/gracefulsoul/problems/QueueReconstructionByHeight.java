package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class QueueReconstructionByHeight {

	// https://leetcode.com/submissions/detail/654385559/
	public static void main(String[] args) {
		QueueReconstructionByHeight test = new QueueReconstructionByHeight();
		PrintUtil.print(test.reconstructQueue(new int[][] {
			new int[] { 7, 0 },
			new int[] { 4, 4 },
			new int[] { 7, 1 },
			new int[] { 5, 0 },
			new int[] { 6, 1 },
			new int[] { 5, 2 }
		}));
		PrintUtil.print(test.reconstructQueue(new int[][] {
			new int[] { 6, 0 },
			new int[] { 5, 0 },
			new int[] { 4, 0 },
			new int[] { 3, 2 },
			new int[] { 2, 2 },
			new int[] { 1, 4 }
		}));
	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (p1, p2) -> {
			int val = p2[0] - p1[0];
			if (val == 0) {
				val = p1[1] - p2[1];
			}
			return val;
		});
		List<int[]> result = new ArrayList<>();
		for (int[] p : people) {
			result.add(p[1], p);
		}
		return result.toArray(new int[0][]);
	}

}

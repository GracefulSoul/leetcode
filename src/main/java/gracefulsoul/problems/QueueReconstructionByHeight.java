package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	// https://leetcode.com/submissions/detail/654379068/
	public static void main(String[] args) {
		QueueReconstructionByHeight test = new QueueReconstructionByHeight();
		print(test.reconstructQueue(new int[][] {
			new int[] { 7, 0 },
			new int[] { 4, 4 },
			new int[] { 7, 1 },
			new int[] { 5, 0 },
			new int[] { 6, 1 },
			new int[] { 5, 2 }
		}));
		print(test.reconstructQueue(new int[][] {
			new int[] { 6, 0 },
			new int[] { 5, 0 },
			new int[] { 4, 0 },
			new int[] { 3, 2 },
			new int[] { 2, 2 },
			new int[] { 1, 4 }
		}));
	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
                int val = p2[0] - p1[0];
                if (val == 0) {
                	val = p1[1] - p2[1];
                }
                return val;
			}
		});
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
        	result.add(p[1], p);
        }
        return result.toArray(new int[0][]);
	}

	private static void print(int[][] array) {
		for (int[] row : array) {
			System.out.print("[");
			for (int idx = 0; idx < row.length; idx++) {
				System.out.print(row[idx]);
				if (idx < row.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
		}
		System.out.println();
	}

}

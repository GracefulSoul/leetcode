package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {

	// https://leetcode.com/submissions/detail/632815975/
	public static void main(String[] args) {
		FindKPairsWithSmallestSums test = new FindKPairsWithSmallestSums();
		System.out.println(test.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3));
		System.out.println(test.kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2));
		System.out.println(test.kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3));
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
		for (int idx = 0; idx < nums1.length && idx < k; idx++) {
			queue.offer(new int[] { nums1[idx], nums2[0], 0 });
		}
		while (k-- > 0 && !queue.isEmpty()) {
			int[] curr = queue.poll();
			List<Integer> temp = new ArrayList<>();
			temp.add(curr[0]);
			temp.add(curr[1]);
			result.add(temp);
			if (curr[2] == nums2.length - 1) {
				continue;
			}
			queue.offer(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
		}
		return result;
	}

}

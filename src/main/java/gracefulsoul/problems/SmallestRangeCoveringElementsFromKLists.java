package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class SmallestRangeCoveringElementsFromKLists {

	// https://leetcode.com/submissions/detail/779321140/
	public static void main(String[] args) {
		SmallestRangeCoveringElementsFromKLists test = new SmallestRangeCoveringElementsFromKLists();
		List<List<Integer>> nums1 = new ArrayList<>();
		nums1.add(Arrays.asList(4, 10, 15, 24, 26));
		nums1.add(Arrays.asList(0, 9, 12, 20));
		nums1.add(Arrays.asList(5, 18, 22, 30));
		PrintUtil.print(test.smallestRange(nums1));
		List<List<Integer>> nums2 = new ArrayList<>();
		nums1.add(Arrays.asList(1, 2, 3));
		nums1.add(Arrays.asList(1, 2, 3));
		nums1.add(Arrays.asList(1, 2, 3));
		PrintUtil.print(test.smallestRange(nums2));

	}

	public int[] smallestRange(List<List<Integer>> nums) {
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(num -> nums.get(num[0]).get(num[1])));
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = Integer.MAX_VALUE;
		for (int idx = 0; idx < nums.size(); idx++) {
			queue.offer(new int[] { idx, 0 });
			max = Math.max(max, nums.get(idx).get(0));
		}
		while (queue.size() == nums.size()) {
			int[] range = queue.poll();
			int row = range[0];
			int col = range[1];
			if (end - start > max - nums.get(row).get(col)) {
				start = nums.get(row).get(col);
				end = max;
			}
			if (col + 1 < nums.get(row).size()) {
				queue.offer(new int[] { row, col + 1 });
				max = Math.max(max, nums.get(row).get(col + 1));
			}
		}
		return new int[] { start, end };
	}

}

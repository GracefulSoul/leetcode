package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZeroArrayTransformationIII {

	// https://leetcode.com/problems/zero-array-transformation-iii/submissions/1641174043/
	public static void main(String[] args) {
		ZeroArrayTransformationIII test = new ZeroArrayTransformationIII();
		System.out.println(test.maxRemoval(new int[] { 2, 0, 2 }, new int[][] {
			{ 0, 2 },
			{ 0, 2 },
			{ 1, 1 }
		}));
		System.out.println(test.maxRemoval(new int[] { 1, 1, 1, 1 }, new int[][] {
			{ 1, 3 },
			{ 0, 2 },
			{ 1, 3 },
			{ 1, 2 }
		}));
		System.out.println(test.maxRemoval(new int[] { 1, 2, 3, 4 }, new int[][] {
			{ 0, 3 }
		}));
	}

	public int maxRemoval(int[] nums, int[][] queries) {
		int length = nums.length;
		int queryCount = queries.length;
		Arrays.sort(queries, (a, b) -> a[0] - b[0]);
		Queue<Integer> queue = new PriorityQueue<>();
		int[] end = new int[length + 1];
		int j = 0;
		int curr = 0;
		for (int i = 0; i < length; i++) {
			curr -= end[i];
			while (j < queryCount && queries[j][0] <= i) {
				queue.offer(-queries[j++][1]);
			}
			while (curr < nums[i]) {
				if (queue.isEmpty() || -queue.peek() < i) {
					return -1;
				}
				end[-queue.poll() + 1]++;
				curr++;
			}
		}
		return queue.size();
	}

}

package gracefulsoul.problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximalScoreAfterApplyingKOperations {

	// https://leetcode.com/problems/maximal-score-after-applying-k-operations/submissions/1422047608/
	public static void main(String[] args) {
		MaximalScoreAfterApplyingKOperations test = new MaximalScoreAfterApplyingKOperations();
		System.out.println(test.maxKelements(new int[] { 10, 10, 10, 10, 10 }, 5));
		System.out.println(test.maxKelements(new int[] { 1, 10, 3, 3, 3 }, 3));
	}

	public long maxKelements(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : nums) {
			queue.add(num);
		}
		long result = 0;
		while (k-- > 0) {
			int num = queue.poll();
			result += num;
			queue.add((num + 2) / 3);
		}
		return result;
	}

}

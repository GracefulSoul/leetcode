package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumNumberOfTasksYouCanAssign {

	// https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/submissions/1622412993/
	public static void main(String[] args) {
		MaximumNumberOfTasksYouCanAssign test = new MaximumNumberOfTasksYouCanAssign();
		System.out.println(test.maxTaskAssign(new int[] { 3, 2, 1 }, new int[] { 0, 3, 3 }, 1, 1));
		System.out.println(test.maxTaskAssign(new int[] { 5, 4 }, new int[] { 0, 0, 0 }, 1, 5));
		System.out.println(test.maxTaskAssign(new int[] { 10, 15, 30 }, new int[] { 0, 10, 10, 10, 10 }, 3, 10));
	}

	public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
		int left = 0;
		int right = Math.min(tasks.length, workers.length);
		Arrays.sort(tasks);
		Arrays.sort(workers);
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (this.canAssign(tasks, workers, pills, strength, mid)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (this.canAssign(tasks, workers, pills, strength, right)) {
			return right;
		} else {
			return left;
		}
	}

	private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int count) {
		Deque<Integer> deque = new ArrayDeque<>();
		int index = workers.length - 1;
		for (int i = count - 1; i >= 0; i--) {
			while (index >= workers.length - count && workers[index] + strength >= tasks[i]) {
				deque.offerLast(workers[index]);
				index--;
			}
			if (deque.isEmpty()) {
				return false;
			}
			if (deque.peekFirst() >= tasks[i]) {
				deque.pollFirst();
			} else {
				deque.pollLast();
				pills--;
				if (pills < 0) {
					return false;
				}
			}
		}
		return true;
	}

}

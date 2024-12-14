package gracefulsoul.problems;

import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarrays {

	// https://leetcode.com/problems/continuous-subarrays/submissions/1478324244/
	public static void main(String[] args) {
		ContinuousSubarrays test = new ContinuousSubarrays();
		System.out.println(test.continuousSubarrays(new int[] { 5, 4, 2, 4 }));
		System.out.println(test.continuousSubarrays(new int[] { 1, 2, 3 }));
	}

	public long continuousSubarrays(int[] nums) {
		long result = 0;
		Deque<Integer> ascending = new LinkedList<>();
		Deque<Integer> descending = new LinkedList<>();
		for (int i = 0, j = -1; i < nums.length; i++) {
			while (!ascending.isEmpty() && ascending.peekLast() > nums[i]) {
				ascending.pollLast();
			}
			ascending.add(nums[i]);
			while (!descending.isEmpty() && descending.peekLast() < nums[i]) {
				descending.pollLast();
			}
			descending.add(nums[i]);
			while (descending.peekFirst() - ascending.peekFirst() > 2) {
				j++;
				if (ascending.peekFirst() == nums[j]) {
					ascending.pollFirst();
				}
				if (descending.peekFirst() == nums[j]) {
					descending.pollFirst();
				}
			}
			result += i - j;
		}
		return result;
	}

}

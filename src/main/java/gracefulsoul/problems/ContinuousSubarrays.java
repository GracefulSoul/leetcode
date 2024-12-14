package gracefulsoul.problems;

import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarrays {

	// https://leetcode.com/problems/continuous-subarrays/submissions/1478310538/
	public static void main(String[] args) {
		ContinuousSubarrays test = new ContinuousSubarrays();
		System.out.println(test.continuousSubarrays(new int[] { 5, 4, 2, 4 }));
		System.out.println(test.continuousSubarrays(new int[] { 1, 2, 3 }));
	}

	public long continuousSubarrays(int[] nums) {
		long result = 0;
		Deque<Integer> max = new LinkedList<>();
		Deque<Integer> min = new LinkedList<>();
		for (int i = 0, j = -1; i < nums.length; i++) {
			while (!max.isEmpty() && max.peekLast() > nums[i]) {
				max.pollLast();
			}
			max.add(nums[i]);
			while (!min.isEmpty() && min.peekLast() < nums[i]) {
				min.pollLast();
			}
			min.add(nums[i]);
			while (min.peekFirst() - max.peekFirst() > 2) {
				j++;
				if (max.peekFirst() == nums[j]) {
					max.pollFirst();
				}
				if (min.peekFirst() == nums[j]) {
					min.pollFirst();
				}
			}
			result += i - j;
		}
		return result;
	}

}

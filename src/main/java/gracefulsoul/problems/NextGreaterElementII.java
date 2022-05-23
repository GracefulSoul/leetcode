package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import gracefulsoul.util.PrintUtil;

public class NextGreaterElementII {

	// https://leetcode.com/submissions/detail/705182139/
	public static void main(String[] args) {
		NextGreaterElementII test = new NextGreaterElementII();
		PrintUtil.print(test.nextGreaterElements(new int[] { 1, 2, 1 }));
		PrintUtil.print(test.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 }));
	}

	public int[] nextGreaterElements(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		Deque<int[]> deque = new ArrayDeque<>();
		Arrays.fill(result, -1);
		for (int idx = 0; idx < length * 2; idx++) {
			while (!deque.isEmpty() && deque.peek()[0] < nums[idx % length]) {
				result[deque.removeFirst()[1]] = nums[idx % length];
			}
			if (idx < length) {
				deque.addFirst(new int[] { nums[idx], idx });
			}
		}
		return result;
	}

}

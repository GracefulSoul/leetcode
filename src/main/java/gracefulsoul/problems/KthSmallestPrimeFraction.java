package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class KthSmallestPrimeFraction {

	// https://leetcode.com/problems/k-th-smallest-prime-fraction/submissions/867224667/
	public static void main(String[] args) {
		KthSmallestPrimeFraction test = new KthSmallestPrimeFraction();
		PrintUtil.print(test.kthSmallestPrimeFraction(new int[] { 1, 2, 3, 5 }, 3));
		PrintUtil.print(test.kthSmallestPrimeFraction(new int[] { 1, 7 }, 1));
	}

	public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]]);
		for (int idx = 1; idx < arr.length; idx++) {
			queue.add(new int[] { 0, idx });
		}
		while (--k > 0) {
			int[] fraction = queue.poll();
			if (fraction[0]++ < fraction[1]) {
				queue.add(fraction);
			}
		}
		int[] result = queue.poll();
		return new int[] { arr[result[0]], arr[result[1]] };
	}

}

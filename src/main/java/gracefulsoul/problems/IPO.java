package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {

	// https://leetcode.com/submissions/detail/704382608/
	public static void main(String[] args) {
		IPO test = new IPO();
		System.out.println(test.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
		System.out.println(test.findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }));
	}

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		Queue<int[]> profitsQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		Queue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int idx = 0; idx < profits.length; idx++) {
			if (capital[idx] <= w) {
				profitsQueue.add(new int[] { profits[idx], idx });
			} else {
				capitalQueue.add(new int[] { capital[idx], idx });
			}
		}
		while (k-- > 0 && !profitsQueue.isEmpty()) {
			w += profitsQueue.poll()[0];
			while (!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= w) {
				profitsQueue.add(new int[] { profits[capitalQueue.poll()[1]], 0 });
			}
		}
		return w;
	}

}

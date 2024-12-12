package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class TakeGiftsFromTheRichestPile {

	// https://leetcode.com/problems/take-gifts-from-the-richest-pile/submissions/1476888325/
	public static void main(String[] args) {
		TakeGiftsFromTheRichestPile test = new TakeGiftsFromTheRichestPile();
		System.out.println(test.pickGifts(new int[] { 25, 64, 9, 4, 100 }, 4));
		System.out.println(test.pickGifts(new int[] { 1, 1, 1, 1 }, 4));
	}

	public long pickGifts(int[] gifts, int k) {
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		for (int gift : gifts) {
			queue.add(gift);
		}
		while (k-- > 0) {
			queue.add((int) Math.sqrt(queue.poll()));
		}
		long result = 0;
		while (!queue.isEmpty()) {
			result += queue.poll();
		}
		return result;
	}

}

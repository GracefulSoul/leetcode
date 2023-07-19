package gracefulsoul.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class RevealCardsInIncreasingOrder {

	// https://leetcode.com/problems/reveal-cards-in-increasing-order/submissions/997491489/
	public static void main(String[] args) {
		RevealCardsInIncreasingOrder test = new RevealCardsInIncreasingOrder();
		PrintUtil.print(test.deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 }));
		PrintUtil.print(test.deckRevealedIncreasing(new int[] { 1, 1000 }));
	}

	public int[] deckRevealedIncreasing(int[] deck) {
		int length = deck.length;
		Arrays.sort(deck);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			queue.add(i);
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[queue.poll()] = deck[i];
			queue.add(queue.poll());
		}
		return result;
	}

}

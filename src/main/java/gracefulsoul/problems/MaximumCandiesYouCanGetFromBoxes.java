package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesYouCanGetFromBoxes {

	// https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/submissions/1652199880/
	public static void main(String[] args) {
		MaximumCandiesYouCanGetFromBoxes test = new MaximumCandiesYouCanGetFromBoxes();
		System.out.println(test.maxCandies(new int[] { 1, 0, 1, 0 }, new int[] { 7, 5, 4, 100 }, new int[][] {
			{},
			{},
			{ 1 },
			{}
		}, new int[][] {
			{ 1, 2 },
			{ 3 },
			{},
			{}
		}, new int[] { 0 }));
		System.out.println(test.maxCandies(new int[] { 1, 0, 0, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 1, 1 }, new int[][] {
			{ 1, 2, 3, 4, 5 },
			{},
			{},
			{},
			{},
			{}
		}, new int[][] {
			{ 1, 2, 3, 4, 5 },
			{},
			{},
			{},
			{},
			{}
		}, new int[] { 0 }));
	}

	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] closed = new boolean[status.length];
		for (int initialBox : initialBoxes) {
			if (status[initialBox] == 1) {
				queue.add(initialBox);
			} else {
				closed[initialBox] = true;
			}
		}
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			result += candies[curr];
			for (int key : keys[curr]) {
				if (closed[key]) {
					closed[key] = false;
					queue.add(key);
				}
				status[key] = 1;
			}
			for (int containedBox : containedBoxes[curr]) {
				if (status[containedBox] == 1) {
					queue.add(containedBox);
				} else {
					closed[containedBox] = true;
				}
			}
		}
		return result;
	}

}

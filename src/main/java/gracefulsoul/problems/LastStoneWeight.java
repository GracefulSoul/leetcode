package gracefulsoul.problems;

import java.util.Arrays;

public class LastStoneWeight {

	// https://leetcode.com/problems/last-stone-weight/submissions/1204854088/
	public static void main(String[] args) {
		LastStoneWeight test = new LastStoneWeight();
		System.out.println(test.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
		System.out.println(test.lastStoneWeight(new int[] { 1 }));
	}

	public int lastStoneWeight(int[] stones) {
		Arrays.sort(stones);
		int i = stones.length - 1;
		int j = i - 1;
		while (j >= 0) {
			if (stones[j] == stones[i]) {
				stones[i] = 0;
				stones[j] = 0;
			} else if (stones[j] > stones[i]) {
				stones[j] = stones[j] - stones[i];
				stones[i] = 0;
			} else {
				stones[j] = stones[i] - stones[j];
				stones[i] = 0;
			}
			Arrays.sort(stones, 0, i);
			i--;
			j--;
		}
		return stones[0];
	}

}

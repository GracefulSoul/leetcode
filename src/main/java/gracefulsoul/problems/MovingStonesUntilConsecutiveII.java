package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class MovingStonesUntilConsecutiveII {

	// https://leetcode.com/problems/moving-stones-until-consecutive-ii/submissions/1199040672/
	public static void main(String[] args) {
		MovingStonesUntilConsecutiveII test = new MovingStonesUntilConsecutiveII();
		PrintUtil.print(test.numMovesStonesII(new int[] { 7, 4, 9 }));
		PrintUtil.print(test.numMovesStonesII(new int[] { 6, 5, 4, 3, 10 }));
	}

	public int[] numMovesStonesII(int[] stones) {
		Arrays.sort(stones);
		int length = stones.length;
		int low = length;
		int high = Math.max(stones[length - 1] - stones[1], stones[length - 2] - stones[0]) - length + 2;
		for (int i = 0, j = 0; j < length; j++) {
			while (stones[j] - stones[i] >= length) {
				i++;
			}
			if (j - i + 1 == length - 1 && stones[j] - stones[i] == length - 2) {
				low = Math.min(low, 2);
			} else {
				low = Math.min(low, length - (j - i + 1));
			}
		}
		return new int[] { low, high };
	}

}

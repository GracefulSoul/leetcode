package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class MovingStonesUntilConsecutive {

	// https://leetcode.com/problems/moving-stones-until-consecutive/submissions/1161912635/
	public static void main(String[] args) {
		MovingStonesUntilConsecutive test = new MovingStonesUntilConsecutive();
		PrintUtil.print(test.numMovesStones(1, 2, 5));
		PrintUtil.print(test.numMovesStones(4, 3, 2));
		PrintUtil.print(test.numMovesStones(3, 5, 1));
	}

	public int[] numMovesStones(int a, int b, int c) {
		int[] stones = { a, b, c };
		Arrays.sort(stones);
		if (stones[2] - stones[0] == 2) {
			return new int[] { 0, 0 };
		} else if (Math.min(stones[1] - stones[0], stones[2] - stones[1]) <= 2) {
			return new int[] { 1, stones[2] - stones[0] - 2 };
		} else {
			return new int[] { 2, stones[2] - stones[0] - 2 };
		}
	}

}

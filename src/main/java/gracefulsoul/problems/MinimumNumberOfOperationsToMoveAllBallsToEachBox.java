package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

	// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/submissions/1499390094/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMoveAllBallsToEachBox test = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
		PrintUtil.print(test.minOperations("110"));
		PrintUtil.print(test.minOperations("001011"));
	}

	public int[] minOperations(String boxes) {
		char[] charArray = boxes.toCharArray();
		int length = charArray.length;
		int[] result = new int[length];
		for (int i = 0, move = 0, count = 0; i < length; i++, move += count) {
			result[i] += move;
			if (charArray[i] == '1') {
				count++;
			}
		}
		for (int i = length - 1, move = 0, count = 0; i >= 0; i--, move += count) {
			result[i] += move;
			if (charArray[i] == '1') {
				count++;
			}
		}
		return result;
	}

}

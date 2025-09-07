package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindNUniqueIntegersSumUpToZero {

	// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/submissions/1762219987/
	public static void main(String[] args) {
		FindNUniqueIntegersSumUpToZero test = new FindNUniqueIntegersSumUpToZero();
		PrintUtil.print(test.sumZero(5));
		PrintUtil.print(test.sumZero(3));
		PrintUtil.print(test.sumZero(1));
	}

	public int[] sumZero(int n) {
		int[] result = new int[n];
		int i = 0;
		int j = result.length - 1;
		while (i < j) {
			result[i++] = j;
			result[j] = (-1) * j--;
		}
		return result;
	}

}

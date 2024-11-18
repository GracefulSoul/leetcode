package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DefuseTheBomb {

	// https://leetcode.com/problems/defuse-the-bomb/submissions/1456085350/
	public static void main(String[] args) {
		DefuseTheBomb test = new DefuseTheBomb();
		PrintUtil.print(test.decrypt(new int[] { 5, 7, 1, 4 }, 3));
		PrintUtil.print(test.decrypt(new int[] { 1, 2, 3, 4 }, 0));
		PrintUtil.print(test.decrypt(new int[] { 2, 4, 9, 3 }, -2));
	}

	public int[] decrypt(int[] code, int k) {
		if (k == 0) {
			return new int[code.length];
		}
		int length = code.length;
		int start = 1;
		int end = k;
		if (k < 0) {
			start = length + k;
			end = length - 1;
		}
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += code[i];
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = sum;
			sum -= code[start++ % length] - code[++end % length];
		}
		return result;
	}

}

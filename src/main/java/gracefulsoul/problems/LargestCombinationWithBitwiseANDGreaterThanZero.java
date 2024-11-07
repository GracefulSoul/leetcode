package gracefulsoul.problems;

public class LargestCombinationWithBitwiseANDGreaterThanZero {

	// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/submissions/1445603241/
	public static void main(String[] args) {
		LargestCombinationWithBitwiseANDGreaterThanZero test = new LargestCombinationWithBitwiseANDGreaterThanZero();
		System.out.println(test.largestCombination(new int[] { 16, 17, 71, 62, 12, 24, 14 }));
		System.out.println(test.largestCombination(new int[] { 8, 8 }));
	}

	public int largestCombination(int[] candidates) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int candidate : candidates) {
				if ((candidate & (1 << i)) != 0) {
					count++;
				}
			}
			result = Math.max(result, count);
		}
		return result;
	}

}

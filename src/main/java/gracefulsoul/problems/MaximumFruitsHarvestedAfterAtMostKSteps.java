package gracefulsoul.problems;

public class MaximumFruitsHarvestedAfterAtMostKSteps {

	// https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/submissions/1721388713/
	public static void main(String[] args) {
		MaximumFruitsHarvestedAfterAtMostKSteps test = new MaximumFruitsHarvestedAfterAtMostKSteps();
		System.out.println(test.maxTotalFruits(new int[][] {
			{ 2, 8 },
			{ 6, 3 },
			{ 8, 6 }
		}, 5, 4));
		System.out.println(test.maxTotalFruits(new int[][] {
			{ 0, 9 },
			{ 4, 1 },
			{ 5, 7 },
			{ 6, 2 },
			{ 7, 4 },
			{ 10, 9 }
		}, 5, 4));
		System.out.println(test.maxTotalFruits(new int[][] {
			{ 0, 3 },
			{ 6, 4 },
			{ 8, 5 }
		}, 3, 2));
	}

	public int maxTotalFruits(int[][] fruits, int startPos, int k) {
		int length = fruits.length;
		int i = 0;
		while (i < length && fruits[i][0] < startPos - k) {
			i++;
		}
		int sum = 0;
		int result = 0;
		for (int j = i; j < length && fruits[j][0] <= startPos + k; j++) {
			sum += fruits[j][1];
			while (Math.min(startPos - 2 * fruits[i][0] + fruits[j][0], 2 * fruits[j][0] - fruits[i][0] - startPos) > k) {
				sum -= fruits[i++][1];
			}
			result = Math.max(result, sum);
		}
		return result;
	}

}

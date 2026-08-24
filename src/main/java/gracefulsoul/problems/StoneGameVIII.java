package gracefulsoul.problems;

public class StoneGameVIII {

	// https://leetcode.com/problems/stone-game-viii/submissions/2118366248/
	public static void main(String[] args) {
		StoneGameVIII test = new StoneGameVIII();
		System.out.println(test.stoneGameVIII(new int[] { -1, 2, -3, 4, -5 }));
		System.out.println(test.stoneGameVIII(new int[] { 7, -6, 5, 10, 5, -2, -6 }));
		System.out.println(test.stoneGameVIII(new int[] { -10, -12 }));
	}

	public int stoneGameVIII(int[] stones) {
		int length = stones.length;
		for (int i = 1; i < length; i++) {
			stones[i] += stones[i - 1];
		}
		int result = stones[length - 1];
		for (int i = length - 2; i >= 1; i--) {
			result = Math.max(result, stones[i] - result);
		}
		return result;
	}

}

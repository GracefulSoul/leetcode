package gracefulsoul.problems;

public class PaintingTheWalls {

	public static void main(String[] args) {
		PaintingTheWalls test = new PaintingTheWalls();
		System.out.println(test.paintWalls(new int[] { 1, 2, 3, 2 }, new int[] { 1, 2, 3, 2 }));
		System.out.println(test.paintWalls(new int[] { 2, 3, 4, 2 }, new int[] { 1, 1, 1, 1 }));
	}

	public int paintWalls(int[] cost, int[] time) {
		int length = cost.length;
		int[] dp = new int[length + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1000000000;
		}
		for (int i = 0; i < length; i++) {
			for (int j = length; j > 0; j--) {
				dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
			}
		}
		return dp[length];
	}

}

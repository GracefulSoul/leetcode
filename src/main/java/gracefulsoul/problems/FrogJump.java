package gracefulsoul.problems;

public class FrogJump {

	// https://leetcode.com/submissions/detail/652449539/
	public static void main(String[] args) {
		FrogJump test = new FrogJump();
		System.out.println(test.canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(test.canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public boolean canCross(int[] stones) {
		if (stones[1] != 1) {
			return false;
		}
		int length = stones.length;
		return this.bfs(stones, new boolean[length][length], length, 0, 1);
	}

	private boolean bfs(int[] stones, boolean[][] dp, int length, int last, int current) {
		if (current == length - 1) {
			return true;
		} else if (dp[last][current]) {
			return false;
		} else {
			int lastJump = stones[current] - stones[last];
			int next = current + 1;
			while (next < length && stones[next] <= stones[current] + lastJump + 1) {
				int increment = stones[next] - stones[current] - lastJump;
				if (increment >= -1 && increment <= 1 && this.bfs(stones, dp, length, current, next)) {
					return true;
				}
				next++;
			}
			dp[last][current] = true;
			return false;
		}
	}

}

package gracefulsoul.problems;

import gracefulsoul.object.node.waviness.Node;

public class TotalWavinessOfNumbersInRangeII {

	// https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/submissions/2023161363/
	public static void main(String[] args) {
		TotalWavinessOfNumbersInRangeII test = new TotalWavinessOfNumbersInRangeII();
		System.out.println(test.totalWaviness(120, 130));
		System.out.println(test.totalWaviness(198, 202));
		System.out.println(test.totalWaviness(4848, 4848));
	}

	private String s;
	private Node[][][][][] dp;
	private boolean[][][][][] visited;

	public long totalWaviness(long num1, long num2) {
		return this.solve(num2) - this.solve(num1 - 1);
	}

	private long solve(long n) {
		if (n <= 0) {
			return 0;
		} else {
			this.s = Long.toString(n);
			this.dp = new Node[17][2][2][11][11];
			this.visited = new boolean[17][2][2][11][11];
			return this.dfs(0, 1, 0, new int[] { 10, 10 }).waviness;
		}
	}

	private Node dfs(int i, int tight, int started, int[] prev) {
		if (i == this.s.length()) {
			return new Node(0, 1);
		} else if (this.visited[i][tight][started][prev[1]][prev[0]]) {
			return this.dp[i][tight][started][prev[1]][prev[0]];
		} else {
			this.visited[i][tight][started][prev[1]][prev[0]] = true;
			long totalWaviness = 0;
			long totalCnt = 0;
			int limit = (tight == 1) ? this.s.charAt(i) - '0' : 9;
			for (int j = 0; j <= limit; j++) {
				int nextTight = (tight == 1 && j == limit) ? 1 : 0;
				if (started == 0 && j == 0) {
					Node child = dfs(i + 1, nextTight, 0, new int[] { 10, 10 });
					totalWaviness += child.waviness;
					totalCnt += child.count;
				} else {
					int[] temp = new int[2];
					long add = 0;
					if (started == 0) {
						temp[1] = 10;
						temp[0] = j;
					} else {
						if (prev[1] != 10) {
							boolean peak = (prev[0] > prev[1] && prev[0] > j);
							boolean valley = (prev[0] < prev[1] && prev[0] < j);
							if (peak || valley) {
								add = 1;
							}
						}
						temp[1] = prev[0];
						temp[0] = j;
					}
					Node child = this.dfs(i + 1, nextTight, 1, temp);
					totalWaviness += child.waviness + add * child.count;
					totalCnt += child.count;
				}
			}
			return this.dp[i][tight][started][prev[1]][prev[0]] = new Node(totalWaviness, totalCnt);
		}
	}

}

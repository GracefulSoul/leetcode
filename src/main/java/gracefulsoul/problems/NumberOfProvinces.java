package gracefulsoul.problems;

public class NumberOfProvinces {

	// https://leetcode.com/submissions/detail/732470404/
	public static void main(String[] args) {
		NumberOfProvinces test = new NumberOfProvinces();
		System.out.println(test.findCircleNum(new int[][] {
			{ 1, 1, 0 },
			{ 1, 1, 0 },
			{ 0, 0, 1 }
		}));
		System.out.println(test.findCircleNum(new int[][] {
			{ 1, 0, 0 },
			{ 0, 1, 0 },
			{ 0, 0, 1 }
		}));
	}

	public int findCircleNum(int[][] isConnected) {
		int length = isConnected.length;
		boolean[] visited = new boolean[length];
		int count = 0;
		for (int idx = 0; idx < length; idx++) {
			if (!visited[idx]) {
				this.dfs(isConnected, visited, idx);
				count++;
			}
		}
		return count;
	}

	private void dfs(int[][] isConnected, boolean[] visited, int i) {
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				this.dfs(isConnected, visited, j);
			}
		}
	}

}

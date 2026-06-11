package gracefulsoul.problems;

public class NumberOfWaysToAssignEdgeWeightsI {

	// https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/submissions/2029619272/
	public static void main(String[] args) {
		NumberOfWaysToAssignEdgeWeightsI test = new NumberOfWaysToAssignEdgeWeightsI();
		System.out.println(test.assignEdgeWeights(new int[][] {
			{ 1, 2 }
		}));
		System.out.println(test.assignEdgeWeights(new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 3, 4 },
			{ 3, 5 }
		}));
	}

	private static final int MOD = 1000000007;

	public int assignEdgeWeights(int[][] edges) {
		int length = edges.length + 1;
		int[] counts = new int[length + 1];
		for (int[] edge : edges) {
			counts[edge[0]]++;
			counts[edge[1]]++;
		}
		int[][] graph = new int[length + 1][];
		for (int i = 1; i <= length; i++) {
			graph[i] = new int[counts[i]];
		}
		int[] idx = new int[length + 1];
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph[u][idx[u]++] = v;
			graph[v][idx[v]++] = u;
		}
		int left = 0;
		int right = 0;
		int[] queue = new int[length];
		queue[right++] = 1;
		int[] depth = new int[length + 1];
		boolean[] visited = new boolean[length + 1];
		visited[1] = true;
		int max = 0;
		while (left < right) {
			int curr = queue[left++];
			max = Math.max(max, depth[curr]);
			for (int value : graph[curr]) {
				if (!visited[value]) {
					visited[value] = true;
					depth[value] = depth[curr] + 1;
					queue[right++] = value;
				}
			}
		}
		return (int) this.pow(2, max - 1);
	}

	private long pow(long base, int exp) {
		long result = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = result * base % MOD;
			}
			base = base * base % MOD;
			exp >>= 1;
		}
		return result;
	}

}

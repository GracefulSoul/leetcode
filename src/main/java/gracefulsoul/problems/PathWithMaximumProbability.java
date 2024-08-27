package gracefulsoul.problems;

public class PathWithMaximumProbability {

	// https://leetcode.com/problems/path-with-maximum-probability/submissions/1369877894/
	public static void main(String[] args) {
		PathWithMaximumProbability test = new PathWithMaximumProbability();
		System.out.println(test.maxProbability(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 0, 2 }
		}, new double[] { 0.5, 0.5, 0.2 }, 0, 2));
		System.out.println(test.maxProbability(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 0, 2 }
		}, new double[] { 0.5, 0.5, 0.3 }, 0, 2));
		System.out.println(test.maxProbability(3, new int[][] {
			{ 0, 1 }
		}, new double[] { 0.5 }, 0, 2));
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		double[] max = new double[n];
		max[start_node] = 1.0;
		for (int i = 0; i < n - 1; i++) {
			boolean updated = false;
			for (int j = 0; j < edges.length; j++) {
				int a = edges[j][0];
				int b = edges[j][1];
				double probability = succProb[j];
				if (max[a] * probability > max[b]) {
					max[b] = max[a] * probability;
					updated = true;
				}
				if (max[b] * probability > max[a]) {
					max[a] = max[b] * probability;
					updated = true;
				}
			}
			if (!updated) {
				break;
			}
		}
		return max[end_node];
	}

}

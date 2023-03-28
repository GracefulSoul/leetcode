package gracefulsoul.problems;

public class PossibleBipartition {

	// https://leetcode.com/problems/possible-bipartition/submissions/923643849/
	public static void main(String[] args) {
		PossibleBipartition test = new PossibleBipartition();
		System.out.println(test.possibleBipartition(4, new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 4 }
		}));
		System.out.println(test.possibleBipartition(4, new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 3 }
		}));
	}

	public boolean possibleBipartition(int n, int[][] dislikes) {
		int length = dislikes.length;
		boolean[] visited = new boolean[length];
		int[] graph = new int[n + 1];
		boolean found;
		for (int i = 0; i < length; i++) {
			if (visited[i]) {
				continue;
			}
			graph[dislikes[i][0]] = 1;
			graph[dislikes[i][1]] = 2;
			found = true;
			while (found) {
				found = false;
				for (int j = i + 1; j < length; j++) {
					if (visited[j]) {
						continue;
					}
					int x = graph[dislikes[j][0]];
					int y = graph[dislikes[j][1]];
					if (x == 0 && y == 0) {
						continue;
					}
					if (x > 0 && y > 0) {
						if ((x - y) % 2 == 0) {
							return false;
						}
					} else if (x > 0) {
						graph[dislikes[j][1]] = x + 1;
					} else {
						graph[dislikes[j][0]] = y + 1;
					}
					found = true;
					visited[j] = true;
				}
			}
		}
		return true;
	}

}

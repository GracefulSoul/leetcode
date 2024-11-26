package gracefulsoul.problems;

public class FindChampionII {

	// https://leetcode.com/problems/find-champion-ii/submissions/1463239304/
	public static void main(String[] args) {
		FindChampionII test = new FindChampionII();
		System.out.println(test.findChampion(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}));
		System.out.println(test.findChampion(4, new int[][] {
			{ 0, 2 },
			{ 1, 3 },
			{ 1, 2 }
		}));
	}

	public int findChampion(int n, int[][] edges) {
		boolean[] weak = new boolean[n];
		for (int[] edge : edges) {
			weak[edge[1]] = true;
		}
		int result = -1;
		for (int i = 0; i < n; i++) {
			if (!weak[i]) {
				if (result == -1) {
					result = i;
				} else {
					return -1;
				}
			}
		}
		return result;
	}

}

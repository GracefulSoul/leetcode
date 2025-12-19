package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindAllPeopleWithSecret {

	// https://leetcode.com/problems/find-all-people-with-secret/submissions/1859379169/
	public static void main(String[] args) {
		FindAllPeopleWithSecret test = new FindAllPeopleWithSecret();
		System.out.println(test.findAllPeople(6, new int[][] {
			{ 1, 2, 5 },
			{ 2, 3, 8 },
			{ 1, 5, 10 }
		}, 1));
		System.out.println(test.findAllPeople(4, new int[][] {
			{ 3, 1, 3 },
			{ 1, 2, 2 },
			{ 0, 3, 3 }
		}, 3));
		System.out.println(test.findAllPeople(5, new int[][] {
			{ 3, 4, 2 },
			{ 1, 2, 1 },
			{ 2, 3, 1 }
		}, 1));
	}

	public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] meeting : meetings) {
			adj.get(meeting[0]).add(new int[] { meeting[1], meeting[2] });
			adj.get(meeting[1]).add(new int[] { meeting[0], meeting[2] });
		}
		Queue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
		queue.add(new int[] { 0, 0 });
		queue.add(new int[] { firstPerson, 0 });
		boolean[] visited = new boolean[n];
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (!visited[curr[0]]) {
				visited[curr[0]] = true;
				for (int[] p : adj.get(curr[0])) {
					if (!visited[p[0]] && p[1] >= curr[1]) {
						queue.add(new int[] { p[0], p[1] });
					}
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				result.add(i);
			}
		}
		return result;
	}

}

package gracefulsoul.problems;

public class EscapeTheGhosts {

	// https://leetcode.com/problems/escape-the-ghosts/submissions/868347589/
	public static void main(String[] args) {
		EscapeTheGhosts test = new EscapeTheGhosts();
		System.out.println(test.escapeGhosts(new int[][] {
			{ 1, 0 },
			{ 0, 3 }
		}, new int[] { 0, 1 }));
		System.out.println(test.escapeGhosts(new int[][] {
			{ 1, 0 }
		}, new int[] { 2, 0 }));
		System.out.println(test.escapeGhosts(new int[][] {
			{ 2, 0 }
		}, new int[] { 1, 0 }));
	}

	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int distance = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] ghost : ghosts) {
			if (distance >= Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])) {
				return false;
			}
		}
		return true;
	}

}

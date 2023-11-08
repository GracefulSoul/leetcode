package gracefulsoul.problems;

public class DetermineIfACellIsReachableAtAGivenTime {

	// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/submissions/1094326636/
	public static void main(String[] args) {
		DetermineIfACellIsReachableAtAGivenTime test = new DetermineIfACellIsReachableAtAGivenTime();
		System.out.println(test.isReachableAtTime(2, 4, 7, 7, 6));
		System.out.println(test.isReachableAtTime(3, 1, 7, 3, 3));
	}

	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
		int x = Math.abs(sx - fx);
		int y = Math.abs(sy - fy);
		int min = Math.min(x, y) + Math.abs(y - x);
		if (min == 0) {
			return t != 1;
		} else {
			return t >= min;
		}
	}

}

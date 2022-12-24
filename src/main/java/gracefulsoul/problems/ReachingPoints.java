package gracefulsoul.problems;

public class ReachingPoints {

	// https://leetcode.com/problems/reaching-points/submissions/864506759/
	public static void main(String[] args) {
		ReachingPoints test = new ReachingPoints();
		System.out.println(test.reachingPoints(1, 1, 3, 5));
		System.out.println(test.reachingPoints(1, 1, 2, 2));
		System.out.println(test.reachingPoints(1, 1, 1, 1));
	}

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		while (sx < tx && sy < ty) {
			if (tx < ty) {
				ty %= tx;
			} else {
				tx %= ty;
			}
		}
		return (sx == tx && sy <= ty && (ty - sy) % sx == 0) || (sy == ty && sx <= tx && (tx - sx) % sy == 0);
	}

}

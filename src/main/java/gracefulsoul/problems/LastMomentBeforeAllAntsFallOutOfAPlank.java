package gracefulsoul.problems;

public class LastMomentBeforeAllAntsFallOutOfAPlank {

	// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/submissions/1091136476/
	public static void main(String[] args) {
		LastMomentBeforeAllAntsFallOutOfAPlank test = new LastMomentBeforeAllAntsFallOutOfAPlank();
		System.out.println(test.getLastMoment(4, new int[] { 4, 3 }, new int[] { 0, 1 }));
		System.out.println(test.getLastMoment(7, new int[] {}, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(test.getLastMoment(7, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, new int[] {}));
	}

	public int getLastMoment(int n, int[] left, int[] right) {
		int result = 0;
		for (int point : left) {
			result = Math.max(result, point);
		}
		for (int point : right) {
			result = Math.max(result, n - point);
		}
		return result;
	}

}

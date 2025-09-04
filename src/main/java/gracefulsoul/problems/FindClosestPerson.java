package gracefulsoul.problems;

public class FindClosestPerson {

	// https://leetcode.com/problems/find-closest-person/submissions/1759213468/
	public static void main(String[] args) {
		FindClosestPerson test = new FindClosestPerson();
		System.out.println(test.findClosest(2, 7, 4));
		System.out.println(test.findClosest(2, 5, 6));
		System.out.println(test.findClosest(1, 5, 3));
	}

	public int findClosest(int x, int y, int z) {
		if (x == y || x + y == 2 * z) {
			return 0;
		} else {
			return Math.abs(z - x) < Math.abs(z - y) ? 1 : 2;
		}
	}

}

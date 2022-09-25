package gracefulsoul.problems;

public class BulbSwitcherII {

	// https://leetcode.com/submissions/detail/808159799/
	public static void main(String[] args) {
		BulbSwitcherII test = new BulbSwitcherII();
		System.out.println(test.flipLights(1, 1));
		System.out.println(test.flipLights(2, 1));
		System.out.println(test.flipLights(3, 1));
	}

	public int flipLights(int n, int presses) {
		if (presses == 0) {
			return 1;
		} else if (n <= 0 || presses < 0) {
			return 0;
		} else if (n == 1) {
			return 2;
		} else if (n == 2) {
			return (presses == 1) ? 3 : 4;
		} else {
			return (presses == 1) ? 4 : ((presses == 2) ? 7 : 8);
		}
	}

}

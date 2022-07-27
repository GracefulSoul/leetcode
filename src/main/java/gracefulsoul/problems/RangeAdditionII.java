package gracefulsoul.problems;

public class RangeAdditionII {

	// https://leetcode.com/submissions/detail/758005431/
	public static void main(String[] args) {
		RangeAdditionII test = new RangeAdditionII();
		System.out.println(test.maxCount(3, 3, new int[][] {
			{ 2, 2 },
			{ 3, 3 }
		}));
		System.out.println(test.maxCount(3, 3, new int[][] {
			{ 2, 2 },
			{ 3, 3 },
			{ 3, 3 },
			{ 3, 3 },
			{ 2, 2 }
		}));
		System.out.println(test.maxCount(3, 3, new int[][] {}));
	}

	public int maxCount(int m, int n, int[][] ops) {
		for (int[] op : ops) {
			m = Math.min(m, op[0]);
			n = Math.min(n, op[1]);
		}
		return m * n;
	}

}

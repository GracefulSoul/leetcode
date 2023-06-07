package gracefulsoul.problems;

public class MinimumFlipsToMakeAORBEqualToC {

	// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/submissions/965838904/
	public static void main(String[] args) {
		MinimumFlipsToMakeAORBEqualToC test = new MinimumFlipsToMakeAORBEqualToC();
		System.out.println(test.minFlips(2, 6, 5));
		System.out.println(test.minFlips(4, 2, 7));
		System.out.println(test.minFlips(1, 2, 3));
	}

	public int minFlips(int a, int b, int c) {
		int result = 0;
		while (a > 0 || b > 0 || c > 0) {
			if ((c & 1) == 0) {
				result += (a & 1) + (b & 1);
			} else if ((a & 1) == 0 && (b & 1) == 0) {
				result++;
			}
			a >>= 1;
			b >>= 1;
			c >>= 1;
		}
		return result;
	}

}

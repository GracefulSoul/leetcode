package gracefulsoul.problems;

public class IntegerReplacement {

	// https://leetcode.com/submissions/detail/648436492/
	public static void main(String[] args) {
		IntegerReplacement test = new IntegerReplacement();
//		System.out.println(test.integerReplacement(8));
//		System.out.println(test.integerReplacement(7));
		System.out.println(test.integerReplacement(5));
	}

	public int integerReplacement(int n) {
		int count = 0;
		while (n > 1) {
			if ((n & 1) != 0) {
				n += (n == 3 || ((n >> 1) & 1) == 0) ? -1 : 1;
				count++;
			}
			n >>>= 1;
			count++;
		}
		return count;
	}

}

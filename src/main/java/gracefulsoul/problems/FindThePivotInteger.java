package gracefulsoul.problems;

public class FindThePivotInteger {

	// https://leetcode.com/problems/find-the-pivot-integer/submissions/1202416570/
	public static void main(String[] args) {
		FindThePivotInteger test = new FindThePivotInteger();
		System.out.println(test.pivotInteger(8));
		System.out.println(test.pivotInteger(1));
		System.out.println(test.pivotInteger(4));
	}

	public int pivotInteger(int n) {
		for (int i = 0, j = n, sum = 0; i < j;) {
			if (sum > 0) {
				sum -= j--;
			} else {
				sum += i++;
			}
			if (sum == 0 && i == j) {
				return i;
			}
		}
		return -1;
	}

}

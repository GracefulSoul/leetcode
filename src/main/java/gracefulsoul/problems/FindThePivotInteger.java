package gracefulsoul.problems;

public class FindThePivotInteger {

	// https://leetcode.com/problems/find-the-pivot-integer/submissions/1202407008/
	public static void main(String[] args) {
		FindThePivotInteger test = new FindThePivotInteger();
		System.out.println(test.pivotInteger(8));
		System.out.println(test.pivotInteger(1));
		System.out.println(test.pivotInteger(4));
	}

	public int pivotInteger(int n) {
		int sum = 0;
		for (int i = 0, j = n; i < j;) {
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

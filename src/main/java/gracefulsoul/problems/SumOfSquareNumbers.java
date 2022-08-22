package gracefulsoul.problems;

public class SumOfSquareNumbers {

	// https://leetcode.com/submissions/detail/780196507/
	public static void main(String[] args) {
		SumOfSquareNumbers test = new SumOfSquareNumbers();
		System.out.println(test.judgeSquareSum(5));
		System.out.println(test.judgeSquareSum(3));
	}

	public boolean judgeSquareSum(int c) {
		for (int idx = 2; idx * idx <= c; idx++) {
			int count = 0;
			if (c % idx == 0) {
				while (c % idx == 0) {
					count++;
					c = c / idx;
				}
				if (idx % 4 == 3 && count % 2 != 0) {
					return false;
				}
			}
		}
		return c % 4 != 3;
	}

}

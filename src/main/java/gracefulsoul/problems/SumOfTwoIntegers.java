package gracefulsoul.problems;

public class SumOfTwoIntegers {

	// https://leetcode.com/submissions/detail/632198200/
	public static void main(String[] args) {
		SumOfTwoIntegers test = new SumOfTwoIntegers();
		System.out.println(test.getSum(1, 2));
		System.out.println(test.getSum(2, 3));
	}

	public int getSum(int a, int b) {
		while (a != 0) {
			int carry = (a & b) << 1;
			b = a ^ b;
			a = carry;
		}
		return b;
	}

}

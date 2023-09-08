package gracefulsoul.problems;

public class BrokenCalculator {

	// https://leetcode.com/problems/broken-calculator/submissions/1043769239/
	public static void main(String[] args) {
		BrokenCalculator test = new BrokenCalculator();
		System.out.println(test.brokenCalc(2, 3));
		System.out.println(test.brokenCalc(5, 8));
		System.out.println(test.brokenCalc(3, 10));
	}

	public int brokenCalc(int startValue, int target) {
		int result = 0;
		while (target > startValue) {
			if (target % 2 > 0) {
				target++;
			} else {
				target /= 2;
			}
			result++;
		}
		return result + startValue - target;
	}

}

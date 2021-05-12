package gracefulsoul.problems;

public class DivideTwoIntegers {

	// https://leetcode.com/submissions/detail/492012279/
	public static void main(String[] args) {
		DivideTwoIntegers test = new DivideTwoIntegers();
		System.out.println(test.divide(10, 3));
		System.out.println(test.divide(7, -3));
		System.out.println(test.divide(0, 1));
		System.out.println(test.divide(1, 1));
		System.out.println(test.divide(-2147483648, -1));
	}
	
	public int divide(int dividend, int divisor) {
    	if (dividend == Integer.MIN_VALUE && divisor == -1) {
    		return Integer.MAX_VALUE;
    	} else {
    		return dividend / divisor;
    	}
    }

}

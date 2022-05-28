package gracefulsoul.problems;

public class FibonacciNumber {

	// https://leetcode.com/submissions/detail/708659777/
	public static void main(String[] args) {
		FibonacciNumber test = new FibonacciNumber();
		System.out.println(test.fib(2));
		System.out.println(test.fib(3));
		System.out.println(test.fib(4));
	}

	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int pre = 0;
		int curr = 0;
		int result = 1;
		for (int idx = 2; idx <= n; idx++) {
			pre = curr;
			curr = result;
			result = pre + curr;
		}
		return result;
	}

}

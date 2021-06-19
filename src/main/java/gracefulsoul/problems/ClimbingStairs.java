package gracefulsoul.problems;

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		System.out.println(test.climbStairs(2));
		System.out.println(test.climbStairs(3));
	}

	// Use loop (https://leetcode.com/submissions/detail/510029589/)
	public int climbStairs(int n) {
		int result = 1;
		for (int idx = 0, diff = 0; idx < n; idx++) {
			result += diff;
			diff = result - diff;
		}
		return result;
	}

	// Use array (https://leetcode.com/submissions/detail/510033864/)
//	public int climbStairs(int n) {
//		int[] fibonacci = new int[n + 1];
//		fibonacci[0] = 1;
//		fibonacci[1] = 2;
//		for (int idx = 2; idx < n; idx++) {
//			fibonacci[idx] = fibonacci[idx - 2] + fibonacci[idx - 1];
//		}
//		return fibonacci[n - 1];
//	}

}

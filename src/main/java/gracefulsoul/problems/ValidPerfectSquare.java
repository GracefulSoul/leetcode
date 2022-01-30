package gracefulsoul.problems;

public class ValidPerfectSquare {

	// https://leetcode.com/submissions/detail/630552571/
	public static void main(String[] args) {
		ValidPerfectSquare test = new ValidPerfectSquare();
		System.out.println(test.isPerfectSquare(16));
		System.out.println(test.isPerfectSquare(14));
	}

	public boolean isPerfectSquare(int num) {
		int left = 1;
		int right = num;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int result = num / mid;
			if (result == mid && num % mid == 0) {
				return true;
			} else if (result < mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

}

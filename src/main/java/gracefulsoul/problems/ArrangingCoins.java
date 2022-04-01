package gracefulsoul.problems;

public class ArrangingCoins {

	// https://leetcode.com/submissions/detail/671499742/
	public static void main(String[] args) {
		ArrangingCoins test = new ArrangingCoins();
		System.out.println(test.arrangeCoins(5));
		System.out.println(test.arrangeCoins(8));
	}

	public int arrangeCoins(int n) {
		long left = 0;
		long right = n;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long curr = mid * (mid + 1) / 2;
			if (n < curr) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) right;
	}

}

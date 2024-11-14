package gracefulsoul.problems;

public class MinimizedMaximumOfProductsDistributedToAnyStore {

	// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/submissions/1452431630/
	public static void main(String[] args) {
		MinimizedMaximumOfProductsDistributedToAnyStore test = new MinimizedMaximumOfProductsDistributedToAnyStore();
		System.out.println(test.minimizedMaximum(6, new int[] { 11, 6 }));
		System.out.println(test.minimizedMaximum(7, new int[] { 15, 10, 10 }));
		System.out.println(test.minimizedMaximum(1, new int[] { 100000 }));
	}

	public int minimizedMaximum(int n, int[] quantities) {
		int left = 1;
		int right = 100000;
		while (left < right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int quantity : quantities) {
				sum += (quantity + (mid - 1)) / mid;
			}
			if (sum > n) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}

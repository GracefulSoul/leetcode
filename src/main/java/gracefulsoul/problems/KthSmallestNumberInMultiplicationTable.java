package gracefulsoul.problems;

public class KthSmallestNumberInMultiplicationTable {

	// https://leetcode.com/submissions/detail/805207808/
	public static void main(String[] args) {
		KthSmallestNumberInMultiplicationTable test = new KthSmallestNumberInMultiplicationTable();
		System.out.println(test.findKthNumber(3, 3, 5));
		System.out.println(test.findKthNumber(2, 3, 6));
	}

	public int findKthNumber(int m, int n, int k) {
		int left = 1;
		int right = m * n;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = (mid / n) * n;
			for (int idx = (mid / n) + 1; idx <= m; idx++) {
				count += mid / idx;
			}
			if (count >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}

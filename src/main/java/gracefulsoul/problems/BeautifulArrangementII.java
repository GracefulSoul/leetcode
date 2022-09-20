package gracefulsoul.problems;

public class BeautifulArrangementII {

	// https://leetcode.com/submissions/detail/804396606/
	public static void main(String[] args) {
		BeautifulArrangementII test = new BeautifulArrangementII();
		System.out.println(test.constructArray(3, 1));
		System.out.println(test.constructArray(3, 2));
	}

	public int[] constructArray(int n, int k) {
		int[] result = new int[n];
		int left = 1;
		int right = n;
		for (int idx = 0; idx < n; idx++) {
			result[idx] = k % 2 != 0 ? left++ : right--;
			if (k > 1) {
				k--;
			}
		}
		return result;
	}

}

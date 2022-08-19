package gracefulsoul.problems;

public class KInversePairsArray {

	// https://leetcode.com/submissions/detail/777810115/
	public static void main(String[] args) {
		KInversePairsArray test = new KInversePairsArray();
		System.out.println(test.kInversePairs(3, 0));
		System.out.println(test.kInversePairs(3, 1));
	}

	private static final int MOD = 1000000007;

	public int kInversePairs(int n, int k) {
		int[] store = new int[k + 1], next = new int[k + 1], temp = null;
		store[0] = 1;
		for (int idx = 1; idx < n; idx++) {
			this.dewIt(store, next, k + 1, idx + 1);
			temp = next;
			next = store;
			store = temp;
		}
		return store[k];
	}

	private void dewIt(int[] source, int[] destination, int n, int k) {
		long acc = 0;
		for (int idx = 0; idx < n; idx++) {
			acc += source[idx];
			if (acc >= MOD) {
				acc -= MOD;
			}
			int j = idx - k;
			if (j > -1) {
				acc -= source[j];
				if (acc < 0) {
					acc += MOD;
				}
			}
			destination[idx] = (int) acc;
		}
	}

}

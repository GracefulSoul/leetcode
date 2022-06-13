package gracefulsoul.object.solution.random.pick.weight;

import java.util.Random;

public class Solution {

	private Random random;
	private int[] sum;
	private int length;

	public Solution(int[] w) {
		this.random = new Random();
		for (int idx = 1; idx < w.length; idx++) {
			w[idx] += w[idx - 1];
		}
		this.sum = w;
		this.length = w.length;
	}

	public int pickIndex() {
		int left = 0;
		int right = this.length - 1;
		int index = this.random.nextInt(this.sum[this.length - 1]) + 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (this.sum[mid] == index) {
				return mid;
			} else if (this.sum[mid] < index) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {

	// https://leetcode.com/problems/largest-component-size-by-common-factor/submissions/1000075023/
	public static void main(String[] args) {
		LargestComponentSizeByCommonFactor test = new LargestComponentSizeByCommonFactor();
		System.out.println(test.largestComponentSize(new int[] { 4, 6, 15, 35 }));
		System.out.println(test.largestComponentSize(new int[] { 20, 50, 9, 63 }));
		System.out.println(test.largestComponentSize(new int[] { 2, 3, 6, 7, 4, 12, 21, 39 }));
	}

	private int[] point;

	public int largestComponentSize(int[] nums) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(num, max);
		}
		this.point = new int[max + 1];
		for (int i = 1; i <= max; i++) {
			this.point[i] = i;
		}
		for (int i : nums) {
			for (int j = (int) Math.sqrt(i); j >= 2; j--) {
				if (i % j == 0) {
					this.add(i, j);
					this.add(i, i / j);
				}
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		for (int i : nums) {
			int j = this.get(i);
			if (!map.containsKey(j)) {
				map.put(j, 1);
			} else {
				map.put(j, map.get(j) + 1);
			}
			result = Math.max(result, map.get(j));
		}
		return result;
	}

	private int get(int x) {
		if (this.point[x] == x) {
			return x;
		} else {
			return this.point[x] = this.get(this.point[x]);
		}
	}

	private void add(int x, int y) {
		this.point[this.get(x)] = this.point[this.get(y)];
	}

}

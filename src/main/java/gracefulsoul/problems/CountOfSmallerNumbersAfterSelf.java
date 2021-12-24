package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	// https://leetcode.com/submissions/detail/606262252/
	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
		System.out.println(test.countSmaller(new int[] { 5, 2, 6, 1 }));
		System.out.println(test.countSmaller(new int[] { -1 }));
		System.out.println(test.countSmaller(new int[] { -1, -1 }));
	}

	public List<Integer> countSmaller(int[] nums) {
		int length = nums.length;
		Integer[] result = new Integer[length];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
		}
		for (int idx = 0; idx < length; idx++) {
			nums[idx] = nums[idx] - min + 1;
			max = Math.max(max, nums[idx]);
		}
		int[] tree = new int[max + 1];
		for (int idx = length - 1; idx >= 0; idx--) {
			result[idx] = this.get(tree, nums[idx] - 1);
			this.update(tree, nums[idx]);
		}
		return Arrays.asList(result);
	}

	private void update(int[] tree, int index) {
		int length = tree.length;
		while (index < length) {
			tree[index]++;
			index += (index & -index);
		}
	}

	private int get(int[] tree, int index) {
		int count = 0;
		while (index > 0) {
			count += tree[index];
			index -= (index & -index);
		}
		return count;
	}

}

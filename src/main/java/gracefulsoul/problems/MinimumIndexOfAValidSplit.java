package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class MinimumIndexOfAValidSplit {

	// https://leetcode.com/problems/minimum-index-of-a-valid-split/submissions/1588000960/
	public static void main(String[] args) {
		MinimumIndexOfAValidSplit test = new MinimumIndexOfAValidSplit();
		System.out.println(test.minimumIndex(Arrays.asList(1, 2, 2, 2)));
		System.out.println(test.minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));
		System.out.println(test.minimumIndex(Arrays.asList(3, 3, 3, 3, 7, 2, 2)));
	}

	public int minimumIndex(List<Integer> nums) {
		int size = nums.size();
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				max = num;
			}
			if (max == num) {
				count++;
			} else {
				count--;
			}
		}
		count = 0;
		for (int num : nums) {
			if (num == max) {
				count++;
			}
		}
		if (count <= (size - count) + 1) {
			return -1;
		}
		count = 0;
		for (int i = 0; i < size; i++) {
			if (nums.get(i) == max) {
				count++;
			} else {
				count--;
			}
			if (count == 1) {
				return i;
			}
		}
		return -1;
	}

}

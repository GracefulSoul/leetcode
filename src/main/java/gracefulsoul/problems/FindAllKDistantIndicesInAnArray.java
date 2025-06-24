package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

	// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/submissions/1674760787/
	public static void main(String[] args) {
		FindAllKDistantIndicesInAnArray test = new FindAllKDistantIndicesInAnArray();
		System.out.println(test.findKDistantIndices(new int[] { 3, 4, 9, 1, 3, 9, 5 }, 9, 1));
		System.out.println(test.findKDistantIndices(new int[] { 2, 2, 2, 2, 2 }, 2, 2));
	}

	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> result = new ArrayList<>();
		int curr = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == key) {
				int j = Math.max(curr, i - k);
				curr = Math.min(i + k, length - 1) + 1;
				while (j < curr) {
					result.add(j++);
				}
			}
		}
		return result;
	}

}

package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {

	// https://leetcode.com/problems/find-missing-elements/submissions/2093858076/
	public static void main(String[] args) {
		FindMissingElements test = new FindMissingElements();
		System.out.println(test.findMissingElements(new int[] { 1, 4, 2, 5 }));
		System.out.println(test.findMissingElements(new int[] { 7, 8, 6, 9 }));
		System.out.println(test.findMissingElements(new int[] { 5, 1 }));
	}

	public List<Integer> findMissingElements(int[] nums) {
		Arrays.sort(nums);
		List<Integer> result = new ArrayList<>();
		for (int i = 0, j = nums[0]; i < nums.length; j++) {
			if (j < nums[i]) {
				result.add(j);
			} else {
				i++;
			}
		}
		return result;
	}

}

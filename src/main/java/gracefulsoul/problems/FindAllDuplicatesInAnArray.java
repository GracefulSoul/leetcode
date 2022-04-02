package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

	// https://leetcode.com/submissions/detail/671967231/
	public static void main(String[] args) {
		FindAllDuplicatesInAnArray test = new FindAllDuplicatesInAnArray();
		System.out.println(test.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(test.findDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(test.findDuplicates(new int[] { 1 }));
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int[] count = new int[nums.length];
		for (int num : nums) {
			count[num - 1]++;
		}
		for (int idx = 0; idx < count.length; idx++) {
			if (count[idx] == 2) {
				result.add(idx + 1);
			}
		}
		return result;
	}

}

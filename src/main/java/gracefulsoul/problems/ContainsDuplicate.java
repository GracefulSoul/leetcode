package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	// https://leetcode.com/submissions/detail/575188268/
	public static void main(String[] args) {
		ContainsDuplicate test = new ContainsDuplicate();
		System.out.println(test.containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(test.containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}

}

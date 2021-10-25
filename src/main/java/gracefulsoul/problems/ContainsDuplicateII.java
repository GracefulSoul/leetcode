package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

	// https://leetcode.com/submissions/detail/576780150/
	public static void main(String[] args) {
		ContainsDuplicateII test = new ContainsDuplicateII();
		System.out.println(test.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(test.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(test.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int idx = 0; idx < nums.length; idx++) {
			if (idx > k) {
				set.remove(nums[idx - k - 1]);
			}
			if (!set.add(nums[idx])) {
				return true;
			}
		}
		return false;
	}

}

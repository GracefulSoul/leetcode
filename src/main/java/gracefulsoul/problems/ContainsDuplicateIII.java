package gracefulsoul.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateIII {

	// https://leetcode.com/submissions/detail/577205027/
	public static void main(String[] args) {
		ContainsDuplicateIII test = new ContainsDuplicateIII();
		System.out.println(test.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
		System.out.println(test.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));
		System.out.println(test.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length == 0 || k == 0) {
			return false;
		} else if (t == 0) {
			return this.containsNearbyDuplicate(nums, k);
		} else {
			Map<Long, Integer> map = new HashMap<>();
			for (int idx = 0; idx < nums.length; idx++) {
				Long key = (long)(nums[idx] / t) - (nums[idx] < 0 ? 1 : 0);
				if (map.get(key) != null
						|| ((map.get(key - 1) != null && nums[idx] - map.get(key - 1) <= t))
						|| ((map.get(key + 1) != null && map.get(key + 1) - nums[idx] <= t))) {
					return true;
				}
				map.put(key, nums[idx]);
				if (idx >= k) {
					map.remove((long) nums[idx - k] / t);
				}
			}
			return false;
		}
	}

	private boolean containsNearbyDuplicate(int[] nums, int k) {
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

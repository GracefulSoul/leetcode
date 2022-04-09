package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// https://leetcode.com/submissions/detail/484797660/
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		System.out.println(test.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(test.threeSum(new int[] {}));
		System.out.println(test.threeSum(new int[] { 0 }));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				int j = i + 1;
				int k = nums.length - 1;
				int sum = 0 - nums[i];
				while (j < k) {
					if (nums[j] + nums[k] == sum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1]) {
							j++;
						}
						while (j < k && nums[k - 1] == nums[k]) {
							k--;
						}
						j++;
						k--;
					} else if (nums[j] + nums[k] < sum) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return result;
	}

}

package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	// https://leetcode.com/submissions/detail/581248420/
	public static void main(String[] args) {
		SummaryRanges test = new SummaryRanges();
		System.out.println(test.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(test.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
		System.out.println(test.summaryRanges(new int[] {}));
		System.out.println(test.summaryRanges(new int[] { -1 }));
		System.out.println(test.summaryRanges(new int[] { 0 }));
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		for (int idx = 0; idx < nums.length; idx++) {
			int num = nums[idx];
			while (idx < nums.length - 1 && nums[idx] == nums[idx + 1] - 1) {
				idx++;
			}
			if (num == nums[idx]) {
				result.add(String.valueOf(num));
			} else {
				result.add(String.join("->", String.valueOf(num), String.valueOf(nums[idx])));
			}
		}
		return result;
	}

}

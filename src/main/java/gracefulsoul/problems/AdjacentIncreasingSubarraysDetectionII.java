package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {

	// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/submissions/1802329580/
	public static void main(String[] args) {
		AdjacentIncreasingSubarraysDetectionII test = new AdjacentIncreasingSubarraysDetectionII();
		System.out.println(test.maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
		System.out.println(test.maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
	}

	public int maxIncreasingSubarrays(List<Integer> nums) {
		int curr = 1;
		int prev = 0;
		int result = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i) > nums.get(i - 1)) {
				curr++;
			} else {
				prev = curr;
				curr = 1;
			}
			result = Math.max(result, Math.max(curr / 2, Math.min(prev, curr)));
		}
		return result;
	}

}

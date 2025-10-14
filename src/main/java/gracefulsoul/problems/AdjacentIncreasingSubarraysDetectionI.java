package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {

	// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/submissions/1801195003/
	public static void main(String[] args) {
		AdjacentIncreasingSubarraysDetectionI test = new AdjacentIncreasingSubarraysDetectionI();
		System.out.println(test.hasIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
		System.out.println(test.hasIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5));
	}

	public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
		int curr = 1;
		int prev = 0;
		int max = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i - 1) < nums.get(i)) {
				curr++;
			} else {
				prev = curr;
				curr = 1;
			}
			max = Math.max(max, Math.max(curr / 2, Math.min(prev, curr)));
		}
		return max >= k;
	}

}

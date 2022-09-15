package gracefulsoul.problems;

public class SplitArrayIntoConsecutiveSubsequences {

	// https://leetcode.com/submissions/detail/800368949/
	public static void main(String[] args) {
		SplitArrayIntoConsecutiveSubsequences test = new SplitArrayIntoConsecutiveSubsequences();
		System.out.println(test.isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));
		System.out.println(test.isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));
		System.out.println(test.isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
	}

	public boolean isPossible(int[] nums) {
		int num = -2000;
		int[] prev = new int[3];
		int[] curr = new int[3];
		for (int idx = 0; idx < nums.length;) {
			int count = 0;
			int cur = nums[idx];
			while (idx < nums.length && nums[idx] == cur) {
				idx++;
				count++;
			}
			if (cur != num + 1) {
				if (prev[0] != 0 || prev[1] != 0) {
					return false;
				}
				num = cur;
				prev[0] = count;
				prev[1] = 0;
				prev[2] = 0;
				continue;
			} else if (count < prev[0] + prev[1]) {
				return false;
			} else {
				curr[1] = prev[0];
				curr[2] = prev[1] + Math.min(prev[2], count - (prev[0] + prev[1]));
				curr[0] = Math.max(0, count - prev[0] - prev[1] - prev[2]);
				num = cur;
				prev[0] = curr[0];
				prev[1] = curr[1];
				prev[2] = curr[2];
			}
		}
		return prev[0] == 0 && prev[1] == 0;
	}

}

package gracefulsoul.problems;

public class MinimumReplacementsToSortTheArray {

	// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/submissions/1035887660/
	public static void main(String[] args) {
		MinimumReplacementsToSortTheArray test = new MinimumReplacementsToSortTheArray();
		System.out.println(test.minimumReplacement(new int[] { 3, 9, 3 }));
		System.out.println(test.minimumReplacement(new int[] { 1, 2, 3, 4, 5 }));
	}

	public long minimumReplacement(int[] nums) {
		int length = nums.length;
		int last = nums[length - 1];
		long result = 0;
		for (int i = length - 2; i >= 0; i--) {
			int time = nums[i] / last;
			if (nums[i] % last != 0) {
				last = nums[i] / ++time;
			}
			result += time - 1;
		}
		return result;
	}

}

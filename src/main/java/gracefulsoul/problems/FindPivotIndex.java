package gracefulsoul.problems;

public class FindPivotIndex {

	// https://leetcode.com/submissions/detail/841712946/
	public static void main(String[] args) {
		FindPivotIndex test = new FindPivotIndex();
		System.out.println(test.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
		System.out.println(test.pivotIndex(new int[] { 1, 2, 3 }));
		System.out.println(test.pivotIndex(new int[] { 2, 1, -1 }));
	}

	public int pivotIndex(int[] nums) {
		int sum = 0;
		int half = 0;
		for (int num : nums) {
			sum += num;
		}
		for (int idx = 0; idx < nums.length; idx++) {
			if (half * 2 == sum - nums[idx]) {
				return idx;
			} else {
				half += nums[idx];
			}
		}
		return -1;
	}

}

package gracefulsoul.problems;

public class FirstMissingPositive {

	// https://leetcode.com/submissions/detail/496468825/
	public static void main(String[] args) {
		FirstMissingPositive test = new FirstMissingPositive();
		System.out.println(test.firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(test.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(test.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	public int firstMissingPositive(int[] nums) {
		int idx = 0;
		while (idx < nums.length) {
			if (nums[idx] >= 1 && nums[idx] <= nums.length && nums[idx] > nums[nums[idx] - 1]) {
				this.swap(nums, idx, nums[idx] - 1);
			} else {
				idx++;
			}
		}
		idx = 0;
		while (idx < nums.length && nums[idx] == idx + 1) {
			idx++;
		}
		return idx + 1;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}

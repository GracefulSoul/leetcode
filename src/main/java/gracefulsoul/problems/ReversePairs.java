package gracefulsoul.problems;

public class ReversePairs {

	// https://leetcode.com/submissions/detail/699106478/
	public static void main(String[] args) {
		ReversePairs test = new ReversePairs();
		System.out.println(test.reversePairs(new int[] {}));
	}

	public int reversePairs(int[] nums) {
		return this.mergeSort(nums, new int[nums.length], 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int[] temp, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;
		int result = this.mergeSort(nums, temp, start, mid) + this.mergeSort(nums, temp, mid + 1, end);
		int i = start;
		int j = mid + 1;
		int right = j;
		for (int left = start; left <= mid; left++) {
			while (j <= end && (long) nums[left] > 2 * (long) nums[j]) {
				j++;
			}
			result += j - mid - 1;
			while (right <= end && nums[right] < nums[left]) {
				temp[i++] = nums[right++];
			}
			temp[i++] = nums[left];
		}
		while (right <= end) {
			temp[i++] = nums[right++];
		}
		for (int idx = start; idx <= end; idx++) {
			nums[idx] = temp[idx];
		}
		return result;
	}

}

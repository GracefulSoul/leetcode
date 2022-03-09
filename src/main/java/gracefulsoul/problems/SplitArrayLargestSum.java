package gracefulsoul.problems;

public class SplitArrayLargestSum {

	// https://leetcode.com/submissions/detail/656206564/
	public static void main(String[] args) {
		SplitArrayLargestSum test = new SplitArrayLargestSum();
		System.out.println(test.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println(test.splitArray(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(test.splitArray(new int[] { 1, 4, 4 }, 3));
	}

	public int splitArray(int[] nums, int m) {
		int max = 0;
		int sum = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}
		while (max < sum) {
			int mid = max + (sum - max) / 2;
			if (this.isValid(nums, m, mid)) {
				sum = mid;
			} else {
				max = mid + 1;
			}
		}
		return max;
	}

	private boolean isValid(int[] nums, int m, int mid) {
		int sum = 0;
		int count = 1;
		for (int num : nums) {
			sum += num;
			if (sum > mid) {
				count++;
				sum = num;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}

}

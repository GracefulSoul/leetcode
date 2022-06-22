package gracefulsoul.problems;

public class SingleElementInASortedArray {

	// https://leetcode.com/submissions/detail/728387870/
	public static void main(String[] args) {
		SingleElementInASortedArray test = new SingleElementInASortedArray();
		System.err.println(test.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.err.println(test.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
	}

	public int singleNonDuplicate(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid % 2 == 1) {
				mid--;
			}
			if (nums[mid] == nums[mid + 1]) {
				start = mid + 2;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}

}

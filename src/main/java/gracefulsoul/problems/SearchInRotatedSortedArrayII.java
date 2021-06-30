package gracefulsoul.problems;

public class SearchInRotatedSortedArrayII {

	// https://leetcode.com/submissions/detail/515183219/
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
		System.out.println(test.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0));
		System.out.println(test.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3));
	}

	public boolean search(int[] nums, int target) {
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] == target) {
				return true;
			}
		}
		return false;
	}

}

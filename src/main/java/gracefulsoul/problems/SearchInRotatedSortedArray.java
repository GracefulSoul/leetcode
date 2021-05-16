package gracefulsoul.problems;

public class SearchInRotatedSortedArray {

	// https://leetcode.com/submissions/detail/493873852/
	public static void main(String[] args) {
		SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
		System.out.println(test.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(test.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(test.search(new int[] { 1 }, 0));
	}

	public int search(int[] nums, int target) {
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] == target) {
				return idx;
			}
		}
		return -1;
	}

}

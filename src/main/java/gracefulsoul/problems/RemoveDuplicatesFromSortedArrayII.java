package gracefulsoul.problems;

public class RemoveDuplicatesFromSortedArrayII {

	// https://leetcode.com/submissions/detail/514817750/
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII test = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(test.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
		System.out.println(test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
	}

	public int removeDuplicates(int[] nums) {
		int count = 0;
		for (int n : nums) {
			if (count < 2 || n > nums[count - 2]) {
				nums[count++] = n;
			}
		}
		return count;
	}

}

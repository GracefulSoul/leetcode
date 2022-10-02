package gracefulsoul.problems;

public class RemoveDuplicatesFromSortedArray {

	// https://leetcode.com/submissions/detail/490416459/
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
		System.out.println(test.removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public int removeDuplicates(int[] nums) {
		int idx = 0;
		for (int n : nums) {
			if (idx == 0 || n > nums[idx - 1]) {
				nums[idx++] = n;
			}
		}
		return idx;
	}

}

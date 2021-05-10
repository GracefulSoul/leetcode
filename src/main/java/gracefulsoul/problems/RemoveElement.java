package gracefulsoul.problems;

public class RemoveElement {

	// https://leetcode.com/submissions/detail/491277685/
	public static void main(String[] args) {
		RemoveElement test = new RemoveElement();
		System.out.println(test.removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(test.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));

	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int n : nums) {
			if (n != val) {
				nums[i++] = n;
			}
		}
		return i;
	}
}

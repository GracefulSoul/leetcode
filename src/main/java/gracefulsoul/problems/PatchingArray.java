package gracefulsoul.problems;

public class PatchingArray {

	// https://leetcode.com/submissions/detail/614611959/
	public static void main(String[] args) {
		PatchingArray test = new PatchingArray();
		System.out.println(test.minPatches(new int[] { 1, 3 }, 6));
		System.out.println(test.minPatches(new int[] { 1, 5, 10 }, 20));
		System.out.println(test.minPatches(new int[] { 1, 2, 2 }, 5));
	}

	public int minPatches(int[] nums, int n) {
		int length = nums.length;
		int miss = 1;
		int count = 0;
		for (int idx = 0; 0 < miss && miss <= n;) {
			if (idx < length && nums[idx] <= miss) {
				miss += nums[idx++];
			} else {
				miss += miss;
				count++;
			}
		}
		return count;
	}

}

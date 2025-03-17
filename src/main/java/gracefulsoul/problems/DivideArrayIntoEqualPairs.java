package gracefulsoul.problems;

public class DivideArrayIntoEqualPairs {

	// https://leetcode.com/problems/divide-array-into-equal-pairs/submissions/1576563375/
	public static void main(String[] args) {
		DivideArrayIntoEqualPairs test = new DivideArrayIntoEqualPairs();
		System.out.println(test.divideArray(new int[] { 3, 2, 3, 2, 2, 2 }));
		System.out.println(test.divideArray(new int[] { 1, 2, 3, 4 }));
	}

	public boolean divideArray(int[] nums) {
		int[] counts = new int[501];
		for (int num : nums) {
			counts[num]++;
		}
		for (int count : counts) {
			if (count % 2 != 0) {
				return false;
			}
		}
		return true;
	}

}

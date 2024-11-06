package gracefulsoul.problems;

public class FindIfArrayCanBeSorted {

	// https://leetcode.com/problems/find-if-array-can-be-sorted/submissions/1444662145/
	public static void main(String[] args) {
		FindIfArrayCanBeSorted test = new FindIfArrayCanBeSorted();
		System.out.println(test.canSortArray(new int[] { 8, 4, 2, 30, 15 }));
		System.out.println(test.canSortArray(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.canSortArray(new int[] { 3, 16, 8, 4, 2 }));
	}

	public boolean canSortArray(int[] nums) {
		int prevMax = 0;
		int currMin = 0;
		int currMax = 0;
		int prevCount = 0;
		for (int num : nums) {
			int currCount = Integer.bitCount(num);
			if (prevCount == currCount) {
				currMin = Math.min(currMin, num);
				currMax = Math.max(currMax, num);
			} else if (currMin < prevMax) {
				return false;
			} else {
				prevMax = currMax;
				currMin = currMax = num;
				prevCount = currCount;
			}
		}
		return currMin >= prevMax;
	}

}

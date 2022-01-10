package gracefulsoul.problems;

public class IncreasingTripletSubsequence {

	// https://leetcode.com/submissions/detail/616683654/
	public static void main(String[] args) {
		IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
		System.out.println(test.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(test.increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
	}

	public boolean increasingTriplet(int[] nums) {
		int big = Integer.MAX_VALUE;
		int small = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= small) {
				small = num;
			} else if (num < big) {
				big = num;
			} else if (num > big) {
				return true;
			}
		}
		return false;
	}

}

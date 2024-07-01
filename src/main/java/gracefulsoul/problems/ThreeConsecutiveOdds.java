package gracefulsoul.problems;

public class ThreeConsecutiveOdds {

	// https://leetcode.com/problems/three-consecutive-odds/submissions/1305629620/
	public static void main(String[] args) {
		ThreeConsecutiveOdds test = new ThreeConsecutiveOdds();
		System.out.println(test.threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
		System.out.println(test.threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
	}

	public boolean threeConsecutiveOdds(int[] arr) {
		for (int i = 0, count = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				count = 0;
			} else if (++count == 3) {
				return true;
			}
		}
		return false;
	}

}

package gracefulsoul.problems;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

	// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/submissions/1832187904/
	public static void main(String[] args) {
		CheckIfAll1sAreAtLeastLengthKPlacesAway test = new CheckIfAll1sAreAtLeastLengthKPlacesAway();
		System.out.println(test.kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2));
		System.out.println(test.kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));
	}

	public boolean kLengthApart(int[] nums, int k) {
		for (int i = -1, j = 0; j < nums.length; j++)
			if (nums[j] == 1) {
				if (i != -1 && j - i - 1 < k) {
					return false;
				}
				i = j;
			}
		return true;
	}

}

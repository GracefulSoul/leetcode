package gracefulsoul.problems;

public class KokoEatingBananas {

	// https://leetcode.com/problems/koko-eating-bananas/submissions/916324232/
	public static void main(String[] args) {
		KokoEatingBananas test = new KokoEatingBananas();
		System.out.println(test.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
		System.out.println(test.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
		System.out.println(test.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
	}

	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = 1000000000;
		while (left < right) {
			int mid = (left + right) / 2;
			int time = 0;
			for (int pile : piles) {
				time += (pile + mid - 1) / mid;
			}
			if (time > h) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}

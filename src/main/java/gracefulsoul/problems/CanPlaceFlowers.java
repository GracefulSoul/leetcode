package gracefulsoul.problems;

public class CanPlaceFlowers {

	// https://leetcode.com/submissions/detail/761006010/
	public static void main(String[] args) {
		CanPlaceFlowers test = new CanPlaceFlowers();
		System.out.println(test.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
		System.out.println(test.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			return true;
		}
		int pre = -1;
		for (int idx = 0; idx < flowerbed.length; idx++) {
			if (flowerbed[idx] == 0 &&
					(pre < idx - 1 || idx == 0) &&
					(idx + 1 == flowerbed.length || flowerbed[idx + 1] == 0)) {
				n--;
				if (n == 0) {
					return true;
				}
				pre = idx;
			} else if (flowerbed[idx] == 1) {
				pre = idx;
			}
		}
		return false;
	}

}

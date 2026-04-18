package gracefulsoul.problems;

public class MirrorDistanceOfAnInteger {

	// https://leetcode.com/problems/mirror-distance-of-an-integer/submissions/1981346881/
	public static void main(String[] args) {
		MirrorDistanceOfAnInteger test = new MirrorDistanceOfAnInteger();
		System.out.println(test.mirrorDistance(25));
		System.out.println(test.mirrorDistance(10));
		System.out.println(test.mirrorDistance(7));
	}

	public int mirrorDistance(int n) {
		if (n < 10) {
			return 0;
		} else {
			int reverse = 0;
			int num = n;
			while (num > 0) {
				reverse = (reverse * 10) + num % 10;
				num /= 10;
			}
			return Math.abs(n - reverse);
		}
	}

}

package gracefulsoul.problems;

public class AngleBetweenHandsOfAClock {

	// https://leetcode.com/problems/angle-between-hands-of-a-clock/submissions/2037507016/
	public static void main(String[] args) {
		AngleBetweenHandsOfAClock test = new AngleBetweenHandsOfAClock();
		System.out.println(test.angleClock(12, 30));
		System.out.println(test.angleClock(3, 30));
		System.out.println(test.angleClock(3, 15));
	}

	public double angleClock(int hour, int minutes) {
		double angle = Math.abs(((hour * 30) + (minutes / 2.0)) - (minutes * 6));
		return Math.min(angle, 360 - angle);
	}

}

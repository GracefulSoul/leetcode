package gracefulsoul.problems;

public class DayOfTheYear {

	// https://leetcode.com/problems/day-of-the-year/submissions/1350804105/
	public static void main(String[] args) {
		DayOfTheYear test = new DayOfTheYear();
		System.out.println(test.dayOfYear("2019-01-09"));
		System.out.println(test.dayOfYear("2019-02-10"));
	}

	private static int[] DAYS = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int dayOfYear(String date) {
		int months = Integer.parseInt(date.substring(5, 7));
		int result = months > 2 && this.isLeapYears(Integer.parseInt(date.substring(0, 4))) ? 1 : 0;
		for (int i = 0; i < months - 1; i++) {
			result += DAYS[i];
		}
		return result + Integer.parseInt(date.substring(8));
	}

	private boolean isLeapYears(int year) {
		return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
	}

}

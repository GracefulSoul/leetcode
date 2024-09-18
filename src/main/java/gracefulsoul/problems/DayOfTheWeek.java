package gracefulsoul.problems;

public class DayOfTheWeek {

	// https://leetcode.com/problems/day-of-the-week/submissions/1393828670/
	public static void main(String[] args) {
		DayOfTheWeek test = new DayOfTheWeek();
		System.out.println(test.dayOfTheWeek(31, 8, 2019));
		System.out.println(test.dayOfTheWeek(18, 7, 1999));
		System.out.println(test.dayOfTheWeek(15, 8, 1993));
	}

	private String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public String dayOfTheWeek(int day, int month, int year) {
		if (month < 3) {
			month += 12;
			year -= 1;
		}
		int century = year / 100;
		year %= 100;
		return days[((((century / 4) - (2 * century) + year + (year / 4) + ((13 * (month + 1)) / 5) + day - 1) % 7) + 7) % 7];
	}

}

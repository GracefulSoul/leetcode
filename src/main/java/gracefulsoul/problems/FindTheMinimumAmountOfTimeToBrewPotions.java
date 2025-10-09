package gracefulsoul.problems;

public class FindTheMinimumAmountOfTimeToBrewPotions {

	// https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/submissions/1796073382/
	public static void main(String[] args) {
		FindTheMinimumAmountOfTimeToBrewPotions test = new FindTheMinimumAmountOfTimeToBrewPotions();
		System.out.println(test.minTime(new int[] { 1, 5, 2, 4 }, new int[] { 5, 1, 4, 2 }));
		System.out.println(test.minTime(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 }));
		System.out.println(test.minTime(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2 }));
	}

	public long minTime(int[] skill, int[] mana) {
		int length = skill.length;
		long[] time = new long[length + 1];
		for (int j = 0; j < mana.length; j++) {
			for (int i = 0; i < length; i++) {
				time[i + 1] = Math.max(time[i + 1], time[i]) + ((long) mana[j] * skill[i]);
			}
			for (int i = length - 1; i > 0; i--) {
				time[i] = time[i + 1] - ((long) mana[j] * skill[i]);
			}
		}
		return time[length];
	}

}

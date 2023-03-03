package gracefulsoul.problems;

public class LemonadeChange {

	// https://leetcode.com/problems/lemonade-change/submissions/908282536/
	public static void main(String[] args) {
		LemonadeChange test = new LemonadeChange();
		System.out.println(test.lemonadeChange(new int[] { 5, 5, 5, 10, 20 }));
		System.out.println(test.lemonadeChange(new int[] { 5, 5, 10, 10, 20 }));
	}

	public boolean lemonadeChange(int[] bills) {
		int[] changes = new int[] { 0, 0 };
		for (int bill : bills) {
			if (bill == 5) {
				changes[0]++;
			} else if (bill == 10) {
				changes[0]--;
				changes[1]++;
			} else if (changes[1] > 0) {
				changes[1]--;
				changes[0]--;
			} else {
				changes[0] -= 3;
			}
			if (changes[0] < 0) {
				return false;
			}
		}
		return true;
	}

}

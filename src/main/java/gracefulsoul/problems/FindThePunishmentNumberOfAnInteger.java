package gracefulsoul.problems;

public class FindThePunishmentNumberOfAnInteger {

	// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/submissions/1543373436/
	public static void main(String[] args) {
		FindThePunishmentNumberOfAnInteger test = new FindThePunishmentNumberOfAnInteger();
		System.out.println(test.punishmentNumber(10));
		System.out.println(test.punishmentNumber(37));
	}

	public int punishmentNumber(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (this.isPunishmentNumber(i, Integer.toString(i * i), 0)) {
				result += i * i;
			}
		}
		return result;
	}

	private boolean isPunishmentNumber(int n, String s, int count) {
		if (s.isEmpty()) {
			return count == n;
		}
		for (int i = 0; i < s.length(); i++) {
			if (this.isPunishmentNumber(n, s.substring(i + 1), count + Integer.valueOf(s.substring(0, i + 1)))) {
				return true;
			}
		}
		return false;
	}

}

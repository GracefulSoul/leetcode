package gracefulsoul.problems;

public class NumberOfWaysToDivideALongCorridor {

	// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/submissions/1108107032/
	public static void main(String[] args) {
		NumberOfWaysToDivideALongCorridor test = new NumberOfWaysToDivideALongCorridor();
		System.out.println(test.numberOfWays("SSPPSPS"));
		System.out.println(test.numberOfWays("PPSPSP"));
		System.out.println(test.numberOfWays("S"));
	}

	public int numberOfWays(String corridor) {
		char[] charArray = corridor.toCharArray();
		int length = charArray.length;
		int seat = 0;
		long result = 1;
		for (int i = 0; i < length; i++) {
			if (charArray[i] == 'S') {
				seat++;
				while (++i < length && charArray[i] != 'S') {
				}
				if (i < length && charArray[i] == 'S') {
					seat++;
				}
				int divider = 1;
				while (++i < length && charArray[i] != 'S') {
					divider++;
				}
				if (divider > 1 && i < length) {
					result = (result * divider) % 1000000007;
				}
				i--;
			}
		}
		return seat != 0 && seat % 2 == 0 ? (int) result : 0;
	}

}

package gracefulsoul.problems;

public class NumberOfLaserBeamsInABank {

	// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/submissions/1135169507/
	public static void main(String[] args) {
		NumberOfLaserBeamsInABank test = new NumberOfLaserBeamsInABank();
		System.out.println(test.numberOfBeams(new String[] { "011001", "000000", "010100", "001000" }));
		System.out.println(test.numberOfBeams(new String[] { "000", "111", "000" }));
	}

	public int numberOfBeams(String[] bank) {
		int result = 0;
		int prev = 0;
		int curr = 0;
		for (String s : bank) {
			curr = 0;
			for (char c : s.toCharArray()) {
				if (c == '1') {
					curr++;
				}
			}
			if (curr > 0) {
				result += prev * curr;
				prev = curr;
			}
		}
		return result;
	}

}

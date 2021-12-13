package gracefulsoul.problems;

public class BullsAndCows {

	// https://leetcode.com/submissions/detail/600493562/
	public static void main(String[] args) {
		BullsAndCows test = new BullsAndCows();
		System.out.println(test.getHint("1807", "7810"));
		System.out.println(test.getHint("1123", "0111"));
		System.out.println(test.getHint("1", "0"));
		System.out.println(test.getHint("1", "1"));
	}

	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] count = new int[10];
		for (int idx = 0; idx < secret.length(); idx++) {
			char secretChar = secret.charAt(idx);
			char guessChar = guess.charAt(idx);
			if (secretChar == guessChar) {
				bulls++;
			} else {
				if (count[secretChar - '0']++ < 0) {
					cows++;
				}
				if (count[guessChar - '0']-- > 0) {
					cows++;
				}
			}
		}
		return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
	}

}

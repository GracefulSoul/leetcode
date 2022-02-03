package gracefulsoul.problems;

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is lower than the guess number 1 if num is higher than the
 *         guess number otherwise return 0 int guess(int num);
 */
public class GuessNumberHigherOrLower extends GuessGame {

	// https://leetcode.com/submissions/detail/633388641/
	public static void main(String[] args) {
		GuessNumberHigherOrLower test = new GuessNumberHigherOrLower();
		System.out.println(test.guessNumber(10));
		System.out.println(test.guessNumber(1));
		System.out.println(test.guessNumber(2));
	}

	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low < high) {
			int mid = low + ((high - low) / 2);
			switch (super.guess(mid)) {
				case -1: high = mid; break;
				case 1: low = mid + 1; break;
				case 0: return mid;
			}
		}
		return low;
	}

}

class GuessGame {
	public int guess(int num) {
		return 0;
	}
}
package gracefulsoul.problems;

public class TwoKeysKeyboard {

	// https://leetcode.com/submissions/detail/793774891/
	public static void main(String[] args) {
		TwoKeysKeyboard test = new TwoKeysKeyboard();
		System.out.println(test.minSteps(3));
		System.out.println(test.minSteps(1));
	}

	public int minSteps(int n) {
		int result = 0;
		for (int idx = 2; idx * idx <= n;) {
			if (n % idx == 0) {
				result += idx;
				n /= idx;
			} else {
				idx++;
			}
		}
		if (n != 1) {
			result += n;
		}
		return result;
	}

}

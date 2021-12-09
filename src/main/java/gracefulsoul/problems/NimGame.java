package gracefulsoul.problems;

public class NimGame {

	// https://leetcode.com/submissions/detail/599204354/
	public static void main(String[] args) {
		NimGame test = new NimGame();
		System.out.println(test.canWinNim(4));
		System.out.println(test.canWinNim(1));
		System.out.println(test.canWinNim(2));
	}

	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

}

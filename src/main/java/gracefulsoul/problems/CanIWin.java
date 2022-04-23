package gracefulsoul.problems;

public class CanIWin {

	// https://leetcode.com/submissions/detail/685692531/
	public static void main(String[] args) {
		CanIWin test = new CanIWin();
		System.out.println(test.canIWin(10, 11));
		System.out.println(test.canIWin(10, 0));
		System.out.println(test.canIWin(10, 1));
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
			return false;
		} else if (maxChoosableInteger >= desiredTotal) {
			return true;
		} else { 
			return this.dfs(maxChoosableInteger, desiredTotal, new boolean[1 << maxChoosableInteger], 0);
		}
	}

	private boolean dfs(int max, int total, boolean[] state, int cur) {
		if (state[cur]) {
			return state[cur];
		}
		for (int idx = 0; idx < max; idx++) {
			if ((cur & 1 << idx) != 0) {
				continue;
			} else if (idx + 1 >= total || !this.dfs(max, total - idx - 1, state, cur | 1 << idx)) {
				state[cur] = true;
				return true;
			}
		}
		return false;
	}

}

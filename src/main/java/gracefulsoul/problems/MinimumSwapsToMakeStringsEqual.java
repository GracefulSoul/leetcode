package gracefulsoul.problems;

public class MinimumSwapsToMakeStringsEqual {

	// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/submissions/1557718843/
	public static void main(String[] args) {
		MinimumSwapsToMakeStringsEqual test = new MinimumSwapsToMakeStringsEqual();
		System.out.println(test.minimumSwap("xx", "yy"));
		System.out.println(test.minimumSwap("xy", "yx"));
	}

	public int minimumSwap(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		int x = 0;
		int y = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			if (s1CharArray[i] == 'x' && s2CharArray[i] == 'y') {
				x++;
			} else if (s1CharArray[i] == 'y' && s2CharArray[i] == 'x') {
				y++;
			}
		}
		if (x % 2 != y % 2) {
			return -1;
		} else {
			int result = (x / 2) + (y / 2);
			if (x % 2 == 1) {
				result += 2;
			}
			return result;
		}
	}

}

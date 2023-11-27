package gracefulsoul.problems;

public class SwapAdjacentInLRString {

	// https://leetcode.com/problems/swap-adjacent-in-lr-string/submissions/863541987/
	public static void main(String[] args) {
		SwapAdjacentInLRString test = new SwapAdjacentInLRString();
		System.out.println(test.canTransform("RXXLRXRXL", "XRLXXRRLX"));
		System.out.println(test.canTransform("X", "L"));
	}

	public boolean canTransform(String start, String end) {
		char[] startCharArray = start.toCharArray();
		char[] endCharArray = end.toCharArray();
		int length = startCharArray.length;
		int next = 1;
		for (int idx = 0; idx < length; idx++) {
			if (startCharArray[idx] == endCharArray[idx]) {
				continue;
			}
			if ((startCharArray[idx] == 'R' && endCharArray[idx] == 'X')
					|| (endCharArray[idx] == 'L' && startCharArray[idx] == 'X')) {
				next = Math.max(next, idx + 1);
				while (next < length && startCharArray[next] == startCharArray[idx]) {
					next++;
				}
				if (next == length || startCharArray[next] != endCharArray[idx]) {
					return false;
				}
				startCharArray[next] = startCharArray[idx];
			} else {
				return false;
			}
		}
		return true;
	}

}

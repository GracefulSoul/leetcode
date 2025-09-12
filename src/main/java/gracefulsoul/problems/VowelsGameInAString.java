package gracefulsoul.problems;

public class VowelsGameInAString {

	// https://leetcode.com/problems/vowels-game-in-a-string/submissions/1768175291/
	public static void main(String[] args) {
		VowelsGameInAString test = new VowelsGameInAString();
		System.out.println(test.doesAliceWin("leetcoder"));
		System.out.println(test.doesAliceWin("bbcd"));
	}

	public boolean doesAliceWin(String s) {
		for (char c : s.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				return true;
			}
		}
		return false;
	}

}

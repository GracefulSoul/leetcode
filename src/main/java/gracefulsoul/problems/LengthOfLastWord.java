package gracefulsoul.problems;

public class LengthOfLastWord {

	// https://leetcode.com/submissions/detail/504201297/
	public static void main(String[] args) {
		LengthOfLastWord test = new LengthOfLastWord();
		System.out.println(test.lengthOfLastWord("Hello World"));
		System.out.println(test.lengthOfLastWord(" "));
	}

	public int lengthOfLastWord(String s) {
		int result = 0;
		for (int idx = s.length() - 1; idx >= 0; idx--) {
			if (s.charAt(idx) != ' ') {
				result++;
			} else {
				if (result > 0) {
					break;
				}
			}
		}
		return result;
	}

}

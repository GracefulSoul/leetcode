package gracefulsoul.problems;

public class DetectCapital {

	// https://leetcode.com/submissions/detail/715381732/
	public static void main(String[] args) {
		DetectCapital test = new DetectCapital();
		System.out.println(test.detectCapitalUse("USA"));
		System.out.println(test.detectCapitalUse("FlaG"));
	}

	public boolean detectCapitalUse(String word) {
		int count = 0;
		for (char c : word.toCharArray()) {
			if (c - 97 < 0) {
				count++;
			}
		}
		return count == 0 ||
				word.length() == count ||
				(count == 1 && word.charAt(0) - 97 < 0);
	}

}

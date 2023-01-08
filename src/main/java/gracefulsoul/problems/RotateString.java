package gracefulsoul.problems;

public class RotateString {

	// https://leetcode.com/problems/rotate-string/submissions/873668222/
	public static void main(String[] args) {
		RotateString test = new RotateString();
		System.out.println(test.rotateString("abcde", "cdeab"));
		System.out.println(test.rotateString("abcde", "abced"));
	}

	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}

}

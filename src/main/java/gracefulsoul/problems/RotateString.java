package gracefulsoul.problems;

public class RotateString {

	public static void main(String[] args) {
		RotateString test = new RotateString();
		System.out.println(test.rotateString("abcde", "cdeab"));
		System.out.println(test.rotateString("abcde", "abced"));
	}

	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}

}

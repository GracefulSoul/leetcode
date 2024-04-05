package gracefulsoul.problems;

public class MakeTheStringGreat {

	// https://leetcode.com/problems/make-the-string-great/submissions/1223854538/
	public static void main(String[] args) {
		MakeTheStringGreat test = new MakeTheStringGreat();
		System.out.println(test.makeGood("leEeetcode"));
		System.out.println(test.makeGood("abBAcC"));
		System.out.println(test.makeGood("s"));
	}

	public String makeGood(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
				return this.makeGood(s.substring(0, i) + s.substring(i + 2));
			}
		}
		return s;
	}

}

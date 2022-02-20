package gracefulsoul.problems;

public class IsSubsequence {

	// https://leetcode.com/submissions/detail/645042562/
	public static void main(String[] args) {
		IsSubsequence test = new IsSubsequence();
		System.out.println(test.isSubsequence("abc", "ahbgdc"));
		System.out.println(test.isSubsequence("axc", "ahbgdc"));
	}

	public boolean isSubsequence(String s, String t) {
		int index = -1;
		for (int idx = 0; idx < s.length(); idx++) {
			index = t.indexOf(s.charAt(idx), index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}

}

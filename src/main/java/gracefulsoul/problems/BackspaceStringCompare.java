package gracefulsoul.problems;

public class BackspaceStringCompare {

	// https://leetcode.com/problems/backspace-string-compare/submissions/900033207/
	public static void main(String[] args) {
		BackspaceStringCompare test = new BackspaceStringCompare();
		System.out.println(test.backspaceCompare("ab#c", "ab#c"));
		System.out.println(test.backspaceCompare("ab##", "c#d#"));
		System.out.println(test.backspaceCompare("a#c", "b"));
	}

	public boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		int back = 0;
		while (true) {
			back = 0;
			while (i >= 0 && (back > 0 || s.charAt(i) == '#')) {
				back += s.charAt(i--) == '#' ? 1 : -1;
			}
			back = 0;
			while (j >= 0 && (back > 0 || t.charAt(j) == '#')) {
				back += t.charAt(j--) == '#' ? 1 : -1;
			}
			if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
				i--;
				j--;
			} else {
				break;
			}
		}
		return i == -1 && j == -1;
	}

}

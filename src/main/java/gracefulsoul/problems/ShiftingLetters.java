package gracefulsoul.problems;

public class ShiftingLetters {

	// https://leetcode.com/problems/shifting-letters/submissions/902200498/
	public static void main(String[] args) {
		ShiftingLetters test = new ShiftingLetters();
		System.out.println(test.shiftingLetters("abc", new int[] { 3, 5, 9 }));
		System.out.println(test.shiftingLetters("aaa", new int[] { 1, 2, 3 }));
	}

	public String shiftingLetters(String s, int[] shifts) {
		char[] charArray = s.toCharArray();
		int shift = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			shift += shifts[i] % 26;
			charArray[i] = (char) (((charArray[i] - 'a') + shift) % 26 + 'a');
		}
		return new String(charArray);
	}

}

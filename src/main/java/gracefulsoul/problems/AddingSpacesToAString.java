package gracefulsoul.problems;

public class AddingSpacesToAString {

	// https://leetcode.com/problems/adding-spaces-to-a-string/submissions/1469153846/
	public static void main(String[] args) {
		AddingSpacesToAString test = new AddingSpacesToAString();
		System.out.println(test.addSpaces("LeetcodeHelpsMeLearn", new int[] { 8, 13, 15 }));
		System.out.println(test.addSpaces("icodeinpython", new int[] { 1, 5, 7, 9 }));
		System.out.println(test.addSpaces("spacing", new int[] { 0, 1, 2, 3, 4, 5, 6 }));
	}

	public String addSpaces(String s, int[] spaces) {
		StringBuilder sb = new StringBuilder();
		char[] charArray = s.toCharArray();
		int i = 0;
		for (int space : spaces) {
			while (i < space) {
				sb.append(charArray[i++]);
			}
			sb.append(' ');
		}
		while (i < charArray.length) {
			sb.append(charArray[i++]);
		}
		return sb.toString();
	}

}

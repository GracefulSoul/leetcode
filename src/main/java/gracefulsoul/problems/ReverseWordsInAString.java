package gracefulsoul.problems;

public class ReverseWordsInAString {

	// https://leetcode.com/submissions/detail/551262482/
	public static void main(String[] args) {
		ReverseWordsInAString test = new ReverseWordsInAString();
//		System.out.println(test.reverseWords("the sky is blue"));
//		System.out.println(test.reverseWords("  hello world  "));
//		System.out.println(test.reverseWords("a good   example"));
		System.out.println(test.reverseWords("  Bob    Loves  Alice   "));
//		System.out.println(test.reverseWords("Alice does not even like bob"));
	}

	public String reverseWords(String s) {
		char[] charArr = s.toCharArray();
		int length = charArr.length;
		this.reverse(charArr, 0, length - 1);
		this.reverseWords(charArr, length);
		return this.cleanSpaces(charArr, length);
	}

	private void reverse(char[] charArr, int i, int j) {
		while (i < j) {
			char temp = charArr[i];
			charArr[i++] = charArr[j];
			charArr[j--] = temp;
		}
	}

	private void reverseWords(char[] charArr, int length) {
		int i = 0;
		int j = 0;
		while (i < length) {
			while (i < j || i < length && charArr[i] == ' ') {
				i++;
			}
			while (j < i || j < length && charArr[j] != ' ') {
				j++;
			}
			this.reverse(charArr, i, j - 1);
		}
	}

	private String cleanSpaces(char[] charArr, int length) {
		int i = 0;
		int j = 0;
		while (j < length) {
			while (j < length && charArr[j] == ' ') {
				j++;
			}
			while (j < length && charArr[j] != ' ') {
				charArr[i++] = charArr[j++];
			}
			while (j < length && charArr[j] == ' ') {
				j++;
			}
			if (j < length) {
				charArr[i++] = ' ';
			}
		}
		return new String(charArr).substring(0, i);
	}

}

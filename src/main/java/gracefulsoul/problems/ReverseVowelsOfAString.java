package gracefulsoul.problems;

public class ReverseVowelsOfAString {

	// https://leetcode.com/submissions/detail/623890325/
	public static void main(String[] args) {
		ReverseVowelsOfAString test = new ReverseVowelsOfAString();
		System.out.println(test.reverseVowels("hello"));
		System.out.println(test.reverseVowels("leetcode"));
	}

	public String reverseVowels(String s) {
		char[] sArr = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (this.isConsonant(sArr[start])) {
				if (start >= end) {
					break;
				}
				start++;
			}
			while (this.isConsonant(sArr[end]) && start < end) {
				if (start >= end) {
					break;
				}
				end--;
			}
			char temp = sArr[start];
			sArr[start] = sArr[end];
			sArr[end] = temp;
			start++;
			end--;
		}
		return new String(sArr);
	}

	private boolean isConsonant(char c) {
		return !(c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o'
				|| c == 'U' || c == 'u');
	}

}

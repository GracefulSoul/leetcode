package gracefulsoul.problems;

public class MaximumNumberOfWordsYouCanType {

	// https://leetcode.com/problems/maximum-number-of-words-you-can-type/submissions/1771483969/
	public static void main(String[] args) {
		MaximumNumberOfWordsYouCanType test = new MaximumNumberOfWordsYouCanType();
		System.out.println(test.canBeTypedWords("hello world", "ad"));
		System.out.println(test.canBeTypedWords("leet code", "lt"));
		System.out.println(test.canBeTypedWords("leet code", "e"));
	}

	public int canBeTypedWords(String text, String brokenLetters) {
		int result = 0;
		boolean isFind = false;
		for (char c : text.toCharArray()) {
			if (!isFind && brokenLetters.indexOf(c) > -1) {
				isFind = true;
			} else if (c == ' ') {
				if (!isFind) {
					result++;
				}
				isFind = false;
			}
		}
		if (!isFind) {
			result++;
		}
		return result;
	}

}

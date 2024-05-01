package gracefulsoul.problems;

public class ReversePrefixOfWord {

	// https://leetcode.com/problems/reverse-prefix-of-word/submissions/1246117721/
	public static void main(String[] args) {
		ReversePrefixOfWord test = new ReversePrefixOfWord();
		System.out.println(test.reversePrefix("abcdefd", 'd'));
		System.out.println(test.reversePrefix("xyxzxe", 'z'));
		System.out.println(test.reversePrefix("abcd", 'z'));
	}

	public String reversePrefix(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1) {
			return word;
		} else {
			return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
		}
	}

}

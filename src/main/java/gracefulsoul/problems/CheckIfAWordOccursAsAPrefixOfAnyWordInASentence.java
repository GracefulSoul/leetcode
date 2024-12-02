package gracefulsoul.problems;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

	// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/submissions/1468170667/
	public static void main(String[] args) {
		CheckIfAWordOccursAsAPrefixOfAnyWordInASentence test = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence();
		System.out.println(test.isPrefixOfWord("i love eating burger", "burg"));
		System.out.println(test.isPrefixOfWord("this problem is an easy problem", "pro"));
		System.out.println(test.isPrefixOfWord("i am tired", "you"));
	}

	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].startsWith(searchWord)) {
				return i + 1;
			}
		}
		return -1;
	}

}

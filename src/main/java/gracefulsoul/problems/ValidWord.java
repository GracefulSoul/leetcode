package gracefulsoul.problems;

public class ValidWord {

	// https://leetcode.com/problems/valid-word/submissions/1698600446/
	public static void main(String[] args) {
		ValidWord test = new ValidWord();
		System.out.println(test.isValid("234Adas"));
		System.out.println(test.isValid("b3"));
		System.out.println(test.isValid("a3$e"));
	}

	public boolean isValid(String word) {
		if (word.length() < 3) {
			return false;
		} else {
			int vowels = 0;
			int consonants = 0;
			for (char c : word.toCharArray()) {
				if (Character.isLetter(c)) {
					if ("aeiouAEIOU".indexOf(c) != -1) {
						vowels++;
					} else {
						consonants++;
					}
				} else if (!Character.isDigit(c)) {
					return false;
				}
			}
			return 0 < vowels && 0 < consonants;
		}
	}

}

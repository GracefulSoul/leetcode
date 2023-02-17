package gracefulsoul.problems;

import gracefulsoul.object.Master;

public class GuessTheWord {

	// https://leetcode.com/problems/guess-the-word/submissions/900024409/
	public static void main(String[] args) {
//		master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
//		master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
//		master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
//		master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
//		master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
//		We made 5 calls to master.guess, and one of them was the secret, so we pass the test case.
	}

	public void findSecretWord(String[] words, Master master) {
		boolean[] used = new boolean[words.length];
		int result = 0;
		int guess = 0;
		while (result != 6) {
			result = master.guess(words[guess]);
			used[guess] = true;
			int newGuess = -1;
			for (int i = 0; i < words.length; i++) {
				if (used[i]) {
					continue;
				}
				if (result != this.compare(words[guess], words[i])) {
					used[i] = true;
				} else {
					newGuess = i;
				}
			}
			guess = newGuess;
		}
	}

	private int compare(String word1, String word2) {
		int count = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}

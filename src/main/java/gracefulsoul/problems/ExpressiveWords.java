package gracefulsoul.problems;

public class ExpressiveWords {

	// https://leetcode.com/problems/expressive-words/submissions/880490942/
	public static void main(String[] args) {
		ExpressiveWords test = new ExpressiveWords();
		System.out.println(test.expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" }));
		System.out.println(test.expressiveWords("zzzzzyyyyy", new String[] { "zzyy", "zy", "zyy" }));
	}

	public int expressiveWords(String s, String[] words) {
		int result = 0;
		for (String word : words) {
			if (this.isPossible(s.toCharArray(), word.toCharArray())) {
				result++;
			}
		}
		return result;
	}

	private boolean isPossible(char[] sCharArray, char[] wordCharArray) {
		int sLength = sCharArray.length;
		int wordLength = wordCharArray.length;
		int j = 0;
		for (int i = 0; i < sLength; i++) {
			if (j < wordLength && sCharArray[i] == wordCharArray[j]) {
				j++;
			} else if (!(0 < i && i < sLength - 1 && sCharArray[i - 1] == sCharArray[i] && sCharArray[i] == sCharArray[i + 1])
					&& !(1 < i && sCharArray[i - 2] == sCharArray[i - 1] && sCharArray[i - 1] == sCharArray[i])) {
				return false;
			}
		}
		return j == wordLength;
	}

}

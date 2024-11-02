package gracefulsoul.problems;

public class CircularSentence {

	// https://leetcode.com/problems/circular-sentence/submissions/1440654079/
	public static void main(String[] args) {
		CircularSentence test = new CircularSentence();
		System.out.println(test.isCircularSentence("leetcode exercises sound delightful"));
		System.out.println(test.isCircularSentence("eetcode"));
		System.out.println(test.isCircularSentence("Leetcode is cool"));
	}

	public boolean isCircularSentence(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		for (int i = 0; i < length; i++) {
			if (charArray[i] == ' ' && charArray[i - 1] != charArray[i + 1]) {
				return false;
			}
		}
		return charArray[0] == charArray[length - 1];
	}

}

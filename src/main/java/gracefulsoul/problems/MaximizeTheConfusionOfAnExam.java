package gracefulsoul.problems;

public class MaximizeTheConfusionOfAnExam {

	// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/submissions/988513311/
	public static void main(String[] args) {
		MaximizeTheConfusionOfAnExam test = new MaximizeTheConfusionOfAnExam();
		System.out.println(test.maxConsecutiveAnswers("TTFF", 2));
		System.out.println(test.maxConsecutiveAnswers("TFFT", 1));
		System.out.println(test.maxConsecutiveAnswers("TTFTTFTT", 1));
	}

	public int maxConsecutiveAnswers(String answerKey, int k) {
		int max = 0;
		int i = 0;
		char[] charArray = answerKey.toCharArray();
		int length = charArray.length;
		int[] count = new int[26];
		for (int j = 0; j < length; j++) {
			max = Math.max(max, ++count[charArray[j] - 'A']);
			if (j - i + 1 > max + k) {
				--count[charArray[i++] - 'A'];
			}
		}
		return length - i;
	}

}

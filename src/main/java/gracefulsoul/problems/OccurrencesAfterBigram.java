package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class OccurrencesAfterBigram {

	// https://leetcode.com/problems/occurrences-after-bigram/submissions/1230215801/
	public static void main(String[] args) {
		OccurrencesAfterBigram test = new OccurrencesAfterBigram();
		PrintUtil.print(test.findOcurrences("alice is a good girl she is a good student", "a", "good"));
		PrintUtil.print(test.findOcurrences("we will we will rock you", "we", "will"));
	}

	public String[] findOcurrences(String text, String first, String second) {
		String[] words = text.split(" ");
		List<String> result = new ArrayList<>();
		for (int i = 2; i < words.length; i++) {
			if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
				result.add(words[i]);
			}
		}
		return result.toArray(new String[] {});
	}

}

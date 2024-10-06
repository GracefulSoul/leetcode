package gracefulsoul.problems;

public class SentenceSimilarityIII {

	// https://leetcode.com/problems/sentence-similarity-iii/submissions/1413139314/
	public static void main(String[] args) {
		SentenceSimilarityIII test = new SentenceSimilarityIII();
		System.out.println(test.areSentencesSimilar("My name is Haley", "My Haley"));
		System.out.println(test.areSentencesSimilar("of", "A lot of words"));
		System.out.println(test.areSentencesSimilar("Eating right now", "Eating"));
	}

	public boolean areSentencesSimilar(String sentence1, String sentence2) {
		String[] words1 = sentence1.split(" ");
		String[] words2 = sentence2.split(" ");
		int length1 = words1.length;
		int length2 = words2.length;
		if (length1 == length2) {
			for (int i = 0; i < length1; i++) {
				if (!words1[i].equals(words2[i])) {
					return false;
				}
			}
			return true;
		}
		int i = 0;
		int j = 0;
		while (i < length1 && i < length2 && words1[i].equals(words2[i])) {
			i++;
		}
		while (j < length1 - i && j < length2 - i && words1[length1 - 1 - j].equals(words2[length2 - 1 - j])) {
			j++;
		}
		return i + j >= Math.min(length1, length2);
	}

}

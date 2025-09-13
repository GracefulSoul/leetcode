package gracefulsoul.problems;

public class FindMostFrequentVowelAndConsonant {

	// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/submissions/1768797034/
	public static void main(String[] args) {
		FindMostFrequentVowelAndConsonant test = new FindMostFrequentVowelAndConsonant();
		System.out.println(test.maxFreqSum("successes"));
		System.out.println(test.maxFreqSum("aeiaeia"));
	}

	public int maxFreqSum(String s) {
		int[] counts = new int[26];
		int[] max = new int[2];
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			counts[index]++;
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				max[0] = Math.max(max[0], counts[index]);
			} else {
				max[1] = Math.max(max[1], counts[index]);
			}
		}
		return max[0] + max[1];
	}

}

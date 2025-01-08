package gracefulsoul.problems;

public class CountPrefixAndSuffixPairsI {

	// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/submissions/1501644637/
	public static void main(String[] args) {
		CountPrefixAndSuffixPairsI test = new CountPrefixAndSuffixPairsI();
		System.out.println(test.countPrefixSuffixPairs(new String[] { "a", "aba", "ababa", "aa" }));
		System.out.println(test.countPrefixSuffixPairs(new String[] { "pa", "papa", "ma", "mama" }));
		System.out.println(test.countPrefixSuffixPairs(new String[] { "abab", "ab" }));
	}

	public int countPrefixSuffixPairs(String[] words) {
		int length = words.length;
		int result = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
					result++;
				}
			}
		}
		return result;
	}

}

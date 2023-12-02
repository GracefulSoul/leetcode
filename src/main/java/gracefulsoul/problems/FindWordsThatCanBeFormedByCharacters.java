package gracefulsoul.problems;

public class FindWordsThatCanBeFormedByCharacters {

	// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/submissions/1110636758/
	public static void main(String[] args) {
		FindWordsThatCanBeFormedByCharacters test = new FindWordsThatCanBeFormedByCharacters();
		System.out.println(test.countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
		System.out.println(test.countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));
	}

	public int countCharacters(String[] words, String chars) {
		int[] count = new int[26];
		for (char c : chars.toCharArray()) {
			count[c - 'a']++;
		}
		int result = 0;
		for (String word : words) {
			if (this.canBeFormed(count, word)) {
				result += word.length();
			}
		}
		return result;
	}

	private boolean canBeFormed(int[] count, String word) {
		int[] temp = new int[26];
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			temp[num]++;
			if (temp[num] > count[num]) {
				return false;
			}
		}
		return true;
	}

}

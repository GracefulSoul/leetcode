package gracefulsoul.problems;

public class LetterTilePossibilities {

	// https://leetcode.com/problems/letter-tile-possibilities/submissions/1230763585/
	public static void main(String[] args) {
		LetterTilePossibilities test = new LetterTilePossibilities();
		System.out.println(test.numTilePossibilities("AAB"));
		System.out.println(test.numTilePossibilities("AAABBC"));
		System.out.println(test.numTilePossibilities("V"));
	}

	public int numTilePossibilities(String tiles) {
		int[] count = new int[26];
		for (char c : tiles.toCharArray()) {
			count[c - 'A']++;
		}
		return this.dfs(count);
	}

	private int dfs(int[] count) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				sum++;
				count[i]--;
				sum += this.dfs(count);
				count[i]++;
			}
		}
		return sum;
	}

}

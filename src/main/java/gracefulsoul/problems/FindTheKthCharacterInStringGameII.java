package gracefulsoul.problems;

public class FindTheKthCharacterInStringGameII {

	// https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/submissions/1685943004/
	public static void main(String[] args) {
		FindTheKthCharacterInStringGameII test = new FindTheKthCharacterInStringGameII();
		System.out.println(test.kthCharacter(5, new int[] { 0, 0, 0 }));
		System.out.println(test.kthCharacter(10, new int[] { 0, 1, 0, 1 }));
	}

	public char kthCharacter(long k, int[] operations) {
		int c = 0;
		k--;
		for (int i = 0; k != 0; i++, k >>= 1) {
			c += ((int) (k & 1) & operations[i]);
		}
		return (char) ((c % 26) + 'a');
	}

}

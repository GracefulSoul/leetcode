package gracefulsoul.problems;

public class FindTheKthCharacterInStringGameI {

	// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/submissions/1684861326/
	public static void main(String[] args) {
		FindTheKthCharacterInStringGameI test = new FindTheKthCharacterInStringGameI();
		System.out.println(test.kthCharacter(5));
		System.out.println(test.kthCharacter(10));
	}

	public char kthCharacter(int k) {
		StringBuilder sb = new StringBuilder("a");
		while (sb.length() <= k) {
			int length = sb.length();
			for (int i = 0; i < length; i++) {
				sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
			}
		}
		return sb.charAt(k - 1);
	}

}

package gracefulsoul.problems;

public class VerifyingAnAlienDictionary {

	// https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/1000082177/
	public static void main(String[] args) {
		VerifyingAnAlienDictionary test = new VerifyingAnAlienDictionary();
		System.out.println(test.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(test.isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
		System.out.println(test.isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));
	}

	private int[] point = new int[26];

	public boolean isAlienSorted(String[] words, String order) {
		for (int i = 0; i < order.length(); i++) {
			this.point[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {
			if (this.compare(words[i - 1], words[i])) {
				return false;
			}
		}
		return true;
	}

	private boolean compare(String s1, String s2) {
		int s1Lenth = s1.length();
		int s2Lenth = s2.length();
		for (int i = 0; i < s1Lenth && i < s2Lenth; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return this.point[s1.charAt(i) - 'a'] > this.point[s2.charAt(i) - 'a'];
			}
		}
		return s1Lenth > s2Lenth;
	}

}

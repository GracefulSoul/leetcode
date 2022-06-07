package gracefulsoul.problems;

public class LongestUncommonSubsequenceI {

	// https://leetcode.com/submissions/detail/716416214/
	public static void main(String[] args) {
		LongestUncommonSubsequenceI test = new LongestUncommonSubsequenceI();
		System.out.println(test.findLUSlength("aba", "cdc"));
		System.out.println(test.findLUSlength("aaa", "bbb"));
		System.out.println(test.findLUSlength("aaa", "aaa"));
	}

	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}

}

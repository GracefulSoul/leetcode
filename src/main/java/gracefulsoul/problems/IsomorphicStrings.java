package gracefulsoul.problems;

public class IsomorphicStrings {

	// https://leetcode.com/submissions/detail/568702775/
	public static void main(String[] args) {
		IsomorphicStrings test = new IsomorphicStrings();
		System.out.println(test.isIsomorphic("egg", "add"));
		System.out.println(test.isIsomorphic("foo", "bar"));
		System.out.println(test.isIsomorphic("paper", "title"));
	}

	public boolean isIsomorphic(String s, String t) {
		int[] sm = new int[256];
		int[] tm = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (sm[s.charAt(i)] != tm[t.charAt(i)]) {
				return false;
			} else {
				sm[s.charAt(i)] = tm[t.charAt(i)] = i + 1;
			}
		}
		return true;
	}

}

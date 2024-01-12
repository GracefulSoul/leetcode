package gracefulsoul.problems;

public class DetermineIfStringHalvesAreAlike {

	// https://leetcode.com/problems/determine-if-string-halves-are-alike/submissions/1143780226/
	public static void main(String[] args) {
		DetermineIfStringHalvesAreAlike test = new DetermineIfStringHalvesAreAlike();
		System.out.println(test.halvesAreAlike("book"));
		System.out.println(test.halvesAreAlike("textbook"));
	}

	public boolean halvesAreAlike(String s) {
		String vowels = "aeiouAEIOU";
		int a = 0;
		int b = 0;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			a += vowels.indexOf(s.charAt(i)) > -1 ? 1 : 0;
			b += vowels.indexOf(s.charAt(j)) > -1 ? 1 : 0;
		}
		return a == b;
	}

}

package gracefulsoul.problems;

public class MinimumDeletionsToMakeStringBalanced {

	// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/submissions/1338231271/
	public static void main(String[] args) {
		MinimumDeletionsToMakeStringBalanced test = new MinimumDeletionsToMakeStringBalanced();
		System.out.println(test.minimumDeletions("aababbab"));
		System.out.println(test.minimumDeletions("bbaaaaabb"));
	}

	public int minimumDeletions(String s) {
		int result = 0;
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == 'b') {
				count++;
			} else {
				result = Math.min(result + 1, count);
			}
		}
		return result;
	}

}

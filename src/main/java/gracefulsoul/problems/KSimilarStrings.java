package gracefulsoul.problems;

public class KSimilarStrings {

	// https://leetcode.com/problems/k-similar-strings/submissions/905851931/
	public static void main(String[] args) {
		KSimilarStrings test = new KSimilarStrings();
		System.out.println(test.kSimilarity("ab", "ba"));
		System.out.println(test.kSimilarity("abc", "bca"));
	}

	private int result;
	private int length;

	public int kSimilarity(String s1, String s2) {
		this.result = Integer.MAX_VALUE;
		this.length = s1.length();
		this.dfs(s1.toCharArray(), s2.toCharArray(), 0, 0);
		return this.result;
	}

	private void dfs(char[] s1CharArray, char[] s2CharArray, int start, int curr) {
		if (curr >= this.result) {
			return;
		}
		for (int i = start; i < this.length; i++) {
			if (s1CharArray[i] != s2CharArray[i]) {
				for (int j = i + 1; j < this.length; j++) {
					if (s1CharArray[i] == s2CharArray[j] && s1CharArray[j] != s2CharArray[j]) {
						this.swap(s2CharArray, i, j);
						this.dfs(s1CharArray, s2CharArray, i + 1, curr + 1);
						this.swap(s2CharArray, i, j);
						if (s1CharArray[j] == s2CharArray[i]) {
							break;
						}
					}
				}
				return;
			}
		}
		this.result = Math.min(curr, this.result);
	}

	private void swap(char[] charArray, int i, int j) {
		char c = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = c;
	}

}

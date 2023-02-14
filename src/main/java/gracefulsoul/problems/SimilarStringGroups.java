package gracefulsoul.problems;

public class SimilarStringGroups {

	// https://leetcode.com/problems/similar-string-groups/submissions/897770384/
	public static void main(String[] args) {
		SimilarStringGroups test = new SimilarStringGroups();
		System.out.println(test.numSimilarGroups(new String[] { "tars", "rats", "arts", "star" }));
		System.out.println(test.numSimilarGroups(new String[] { "omv", "ovm" }));
	}

	public int numSimilarGroups(String[] strs) {
		boolean[] visited = new boolean[strs.length];
		int result = 0;
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i]) {
				this.dfs(strs, i, visited);
				result++;
			}
		}
		return result;
	}

	private void dfs(String[] strs, int index, boolean[] visited) {
		visited[index] = true;
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i] && this.isSimilar(strs[index], strs[i])) {
				this.dfs(strs, i, visited);
			}
		}
	}

	private boolean isSimilar(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		return count == 0 || count == 2;
	}

}

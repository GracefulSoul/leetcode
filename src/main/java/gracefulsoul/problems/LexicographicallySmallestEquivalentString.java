package gracefulsoul.problems;

public class LexicographicallySmallestEquivalentString {

	// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/submissions/1214287091/
	public static void main(String[] args) {
		LexicographicallySmallestEquivalentString test = new LexicographicallySmallestEquivalentString();
		System.out.println(test.smallestEquivalentString("parker", "morris", "parser"));
		System.out.println(test.smallestEquivalentString("hello", "world", "hold"));
		System.out.println(test.smallestEquivalentString("leetcode", "programs", "sourcecode"));
	}

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		int[] graph = new int[26];
		for (int i = 0; i < 26; i++) {
			graph[i] = i;
		}
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		for (int i = 0; i < s1.length(); i++) {
			int j = this.find(graph, s1CharArray[i] - 'a');
			int k = this.find(graph, s2CharArray[i] - 'a');
			if (k < j) {
				graph[j] = k;
			} else {
				graph[k] = j;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : baseStr.toCharArray()) {
			sb.append((char) ('a' + this.find(graph, c - 'a')));
		}
		return sb.toString();
	}

	private int find(int[] graph, int index) {
		while (graph[index] != index) {
			index = graph[index];
		}
		return index;
	}

}

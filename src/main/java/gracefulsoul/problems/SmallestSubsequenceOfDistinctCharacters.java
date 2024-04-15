package gracefulsoul.problems;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

	// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/submissions/1232939894/
	public static void main(String[] args) {
		SmallestSubsequenceOfDistinctCharacters test = new SmallestSubsequenceOfDistinctCharacters();
		System.out.println(test.smallestSubsequence("bcabc"));
		System.out.println(test.smallestSubsequence("cbacdcbc"));
	}

	public String smallestSubsequence(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		boolean[] visited = new boolean[26];
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}
			while (!stack.isEmpty() && c < stack.peek() && 0 < count[stack.peek() - 'a']) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			visited[c - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

}

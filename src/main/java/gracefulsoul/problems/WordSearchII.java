package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.trie.word.TrieNode;

public class WordSearchII {

	// https://leetcode.com/submissions/detail/572400235/
	public static void main(String[] args) {
		WordSearchII test = new WordSearchII();
		System.out.println(test.findWords(new char[][] {
			new char[] { 'o', 'a', 'a', 'n' },
			new char[] { 'e', 't', 'a', 'e' },
			new char[] { 'i', 'h', 'k', 'r' },
			new char[] { 'i', 'f', 'l', 'v' }
		}, new String[] { "oath", "pea", "eat", "rain" }));
		System.out.println(test.findWords(new char[][] {
			new char[] { 'a', 'b' },
			new char[] { 'c', 'd' }
		}, new String[] { "abcd" }));
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		TrieNode root = this.initTrieNode(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.dfs(board, i, j, root, result);
			}
		}
		return result;
	}

	private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
		char c = board[i][j];
		int num = c - 'a';
		if (c == '.' || node.children[num] == null) {
			return;
		}
		node = node.children[num];
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[i][j] = '.';
		if (i > 0) {
			this.dfs(board, i - 1, j, node, result);
		}
		if (j > 0) {
			this.dfs(board, i, j - 1, node, result);
		}
		if (i < board.length - 1) {
			this.dfs(board, i + 1, j, node, result);
		}
		if (j < board[0].length - 1) {
			this.dfs(board, i, j + 1, node, result);
		}
		board[i][j] = c;
	}

	private TrieNode initTrieNode(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				int num = c - 'a';
				if (node.children[num] == null) {
					node.children[num] = new TrieNode();
				}
				node = node.children[num];
			}
			node.word = word;
		}
		return root;
	}

}

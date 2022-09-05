package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.trie.word.TrieNode;

public class ReplaceWords {

	// https://leetcode.com/submissions/detail/791998349/
	public static void main(String[] args) {
		System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		System.out.println(new ReplaceWords().replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
	}

	private TrieNode root = new TrieNode();

	public String replaceWords(List<String> dictionary, String sentence) {
		for (String word : dictionary) {
			this.insert(word);
		}
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word : words) {
			sb.append(this.search(word)).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private void insert(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			if (cur.children[num] == null) {
				cur.children[num] = new TrieNode();
			}
			cur = cur.children[num];
		}
		cur.word = word;
	}

	private String search(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			if (cur.children[num] == null) {
				return word;
			}
			cur = cur.children[num];
			if (cur.word != null) {
				return cur.word;
			}
		}
		return word;
	}

}

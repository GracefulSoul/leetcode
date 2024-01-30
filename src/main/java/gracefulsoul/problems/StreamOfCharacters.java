package gracefulsoul.problems;

import gracefulsoul.object.node.trie.check.TrieNode;

public class StreamOfCharacters {

	// https://leetcode.com/problems/stream-of-characters/submissions/1160972457/
	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" });
		System.out.println(streamChecker.query('a')); // return False
		System.out.println(streamChecker.query('b')); // return False
		System.out.println(streamChecker.query('c')); // return False
		System.out.println(streamChecker.query('d')); // return True, because 'cd' is in the wordlist
		System.out.println(streamChecker.query('e')); // return False
		System.out.println(streamChecker.query('f')); // return True, because 'f' is in the wordlist
		System.out.println(streamChecker.query('g')); // return False
		System.out.println(streamChecker.query('h')); // return False
		System.out.println(streamChecker.query('i')); // return False
		System.out.println(streamChecker.query('j')); // return False
		System.out.println(streamChecker.query('k')); // return False
		System.out.println(streamChecker.query('l')); // return True, because 'kl' is in the wordlist
	}

}

class StreamChecker {

	private TrieNode root;
	private StringBuilder sb;

	public StreamChecker(String[] words) {
		this.root = new TrieNode();
		this.sb = new StringBuilder();
		for (String word : words) {
			TrieNode node = this.root;
			char[] charArray = word.toCharArray();
			int length = charArray.length;
			for (int i = length - 1; i >= 0; i--) {
				int index = charArray[i] - 'a';
				if (node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				node = node.children[index];
			}
			node.isWord = true;
		}
	}

	public boolean query(char letter) {
		this.sb.append(letter);
		TrieNode node = this.root;
		for (int i = this.sb.length() - 1; i >= 0 && node != null; i--) {
			node = node.children[this.sb.charAt(i) - 'a'];
			if (node != null && node.isWord) {
				return true;
			}
		}
		return false;
	}

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

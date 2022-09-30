package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.trie.sum.TrieNode;

public class MapSumPairs {

	// https://leetcode.com/submissions/detail/812008967/
	public static void main(String[] args) {
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);  
		System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
		mapSum.insert("app", 2);    
		System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
	}

}

class MapSum {

	private Map<String, Integer> map;
	private TrieNode root;

	public MapSum() {
		this.map = new HashMap<>();
		this.root = new TrieNode();
	}

	public void insert(String key, int val) {
		int diff = val - this.map.getOrDefault(key, 0);
		TrieNode curr = this.root;
		for (char c : key.toCharArray()) {
			int num = c - 'a';
			if (curr.children[num] == null) {
				curr.children[num] = new TrieNode();
			}
			curr = curr.children[num];
			curr.sum += diff;
		}
		this.map.put(key, val);
	}

	public int sum(String prefix) {
		TrieNode curr = this.root;
		for (char c : prefix.toCharArray()) {
			int num = c - 'a';
			if (curr.children[num] == null) {
				return 0;
			}
			curr = curr.children[num];
		}
		return curr.sum;
	}

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
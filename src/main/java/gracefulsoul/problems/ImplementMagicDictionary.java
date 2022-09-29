package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {

	// https://leetcode.com/submissions/detail/811281531/
	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[] {"hello", "leetcode"});
		System.out.println(magicDictionary.search("hello"));		// return False
		System.out.println(magicDictionary.search("hhllo"));		// We can change the second 'h' to 'e' to match "hello" so we return True
		System.out.println(magicDictionary.search("hell"));			// return False
		System.out.println(magicDictionary.search("leetcoded"));	// return False
	}

}

class MagicDictionary {

	private Map<Integer, List<String>> map;

	public MagicDictionary() {
		this.map = new HashMap<>();
	}

	public void buildDict(String[] dictionary) {
		for (String word : dictionary) {
			List<String> words = this.map.get(word.length());
			if (words == null) {
				words = new ArrayList<>();
				this.map.put(word.length(), words);
			}
			words.add(word);
		}
	}

	public boolean search(String searchWord) {
		List<String> words = this.map.get(searchWord.length());
		if (words != null) {
			for (String word : words) {
				int count = 0;
				for (int idx = 0; idx < word.length(); idx++) {
					if (word.charAt(idx) != searchWord.charAt(idx)) {
						count++;
						if (count > 1) {
							break;
						}
					}
				}
				if (count == 1) {
					return true;
				}
			}
		}
		return false;
	}

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
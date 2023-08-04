package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class VowelSpellchecker {

	// https://leetcode.com/problems/vowel-spellchecker/submissions/1011944221/
	public static void main(String[] args) {
		VowelSpellchecker test = new VowelSpellchecker();
		PrintUtil.print(test.spellchecker(new String[] { "KiTe", "kite", "hare", "Hare" }, new String[] { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" }));
		PrintUtil.print(test.spellchecker(new String[] { "yellow" }, new String[] { "YellOw" }));
	}

	public String[] spellchecker(String[] wordlist, String[] queries) {
		int diff = 'a' - 'A';
		Map<Long, String> wordMap = new HashMap<>(wordlist.length << 1);
		Map<Long, String> capMap = new HashMap<>(wordlist.length << 1);
		Map<Long, String> vowelMap = new HashMap<>(wordlist.length << 1);
		for (String word : wordlist) {
			long hash = 0;
			long capHash = 0;
			long vowelHash = 0;
			for (int i = 0, length = word.length(), c; i < length;) {
				hash = (hash << 7) | (c = word.charAt(i++));
				capHash = (capHash << 7) | (c < 'a' ? c += diff : c);
				vowelHash = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? (vowelHash << 7) : (vowelHash << 7) | c;
			}
			wordMap.put(hash, word);
			capMap.putIfAbsent(capHash, word);
			vowelMap.putIfAbsent(vowelHash, word);
		}
		for (int i = 0; i < queries.length; i++) {
			long hash = 0;
			long capHash = 0;
			long vowelHash = 0;
			for (int j = 0, length = queries[i].length(), c; j < length;) {
				hash = (hash << 7) | (c = queries[i].charAt(j++));
				capHash = (capHash << 7) | (c < 'a' ? c += diff : c);
				vowelHash = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? (vowelHash << 7) : (vowelHash << 7) | c;
			}
			if (wordMap.containsKey(hash)) {
				continue;
			}
			String word = capMap.get(capHash);
			queries[i] = word != null ? word : vowelMap.getOrDefault(vowelHash, "");
		}
		return queries;
	}

}

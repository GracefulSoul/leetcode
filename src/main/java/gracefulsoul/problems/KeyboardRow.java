package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class KeyboardRow {

	// https://leetcode.com/submissions/detail/703138600/
	public static void main(String[] args) {
		KeyboardRow test = new KeyboardRow();
		PrintUtil.print(test.findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" }));
		PrintUtil.print(test.findWords(new String[] { "omk" }));
		PrintUtil.print(test.findWords(new String[] { "adsdf", "sfd" }));
	}

	private static final String[] KEYBOARD_ROWS = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };

	public String[] findWords(String[] words) {
		int[] positions = new int[26];
		for (int idx = 0; idx < KEYBOARD_ROWS.length; idx++) {
			for (char c : KEYBOARD_ROWS[idx].toCharArray()) {
				positions[c - 'a'] = idx + 1;
			}	
		}
		List<String> result = new ArrayList<>();
		for (String word : words) {
			int row = 0;
			int idx = 0;
			for (; idx < word.length(); idx++) {
				char c = word.charAt(idx);
				int num = c - (c >= 'a' ? 'a' : 'A');
				if (row == 0) {
					row = positions[num];
				} else if (row != positions[num]) {
					break;
				}
			}
			if (idx == word.length()) {
				result.add(word);
			}
		}
		return result.toArray(new String[result.size()]);
	}

}

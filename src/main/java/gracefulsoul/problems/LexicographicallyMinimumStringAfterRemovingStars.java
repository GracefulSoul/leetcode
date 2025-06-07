package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LexicographicallyMinimumStringAfterRemovingStars {

	// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/submissions/1656122338/
	public static void main(String[] args) {
		LexicographicallyMinimumStringAfterRemovingStars test = new LexicographicallyMinimumStringAfterRemovingStars();
		System.out.println(test.clearStars("aaba*"));
		System.out.println(test.clearStars("abc"));
	}

	public String clearStars(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			lists.add(new ArrayList<>());
		}
		boolean[] removed = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (charArray[i] == '*') {
				removed[i] = true;
				for (int j = 0; j < 26; j++) {
					List<Integer> list = lists.get(j);
					if (!list.isEmpty()) {
						int last = list.size() - 1;
						removed[list.get(last)] = true;
						list.remove(last);
						break;
					}
				}
			} else {
				lists.get(charArray[i] - 'a').add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (!removed[i]) {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}

}

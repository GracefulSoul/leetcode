package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class ReorderDataInLogFiles {

	// https://leetcode.com/problems/reorder-data-in-log-files/submissions/980759529/
	public static void main(String[] args) {
		ReorderDataInLogFiles test = new ReorderDataInLogFiles();
		PrintUtil.print(test.reorderLogFiles(new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }));
		PrintUtil.print(test.reorderLogFiles(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" }));
	}

	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (s1, s2) -> {
			int index1 = s1.indexOf(" ") + 1;
			int index2 = s2.indexOf(" ") + 1;
			boolean isLetter1 = Character.isLetter(s1.charAt(index1));
			boolean isLetter2 = Character.isLetter(s2.charAt(index2));
			if (isLetter1 && isLetter2) {
				int compare = s1.substring(index1).compareTo(s2.substring(index2));
				if (compare != 0) {
					return compare;
				} else {
					return s1.compareTo(s2);
				}
			} else if (isLetter1 && !isLetter2) {
				return -1;
			} else if (!isLetter1 && isLetter2) {
				return 1;
			} else {
				return 0;
			}
		});
		return logs;
	}

}

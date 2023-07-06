package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DIStringMatch {

	// https://leetcode.com/problems/di-string-match/submissions/987644810/
	public static void main(String[] args) {
		DIStringMatch test = new DIStringMatch();
		PrintUtil.print(test.diStringMatch("IDID"));
		PrintUtil.print(test.diStringMatch("III"));
		PrintUtil.print(test.diStringMatch("DDI"));
	}

	public int[] diStringMatch(String s) {
		int length = s.length();
		int left = 0;
		int right = length;
		int[] result = new int[length + 1];
		for (int i = 0; i < length; i++) {
			result[i] = s.charAt(i) == 'I' ? left++ : right--;
		}
		result[s.length()] = left;
		return result;
	}

}

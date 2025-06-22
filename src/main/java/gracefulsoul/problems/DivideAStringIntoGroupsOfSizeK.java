package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DivideAStringIntoGroupsOfSizeK {

	// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/submissions/1672519416/
	public static void main(String[] args) {
		DivideAStringIntoGroupsOfSizeK test = new DivideAStringIntoGroupsOfSizeK();
		PrintUtil.print(test.divideString("abcdefghi", 3, 'x'));
		PrintUtil.print(test.divideString("abcdefghij", 3, 'x'));
	}

	public String[] divideString(String s, int k, char fill) {
		int length = s.length();
		String[] result = new String[(length + k - 1) / k];
		for (int i = 0; i < result.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < k; j++) {
				int index = (i * k) + j;
				if (index < length) {
					sb.append(s.charAt(index));
				} else {
					sb.append(fill);
				}
			}
			result[i] = sb.toString();
		}
		return result;
	}

}

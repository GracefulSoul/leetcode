package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindTheOriginalArrayOfPrefixXor {

	// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/submissions/1088254568/
	public static void main(String[] args) {
		FindTheOriginalArrayOfPrefixXor test = new FindTheOriginalArrayOfPrefixXor();
		PrintUtil.print(test.findArray(new int[] { 5, 2, 0, 3, 1 }));
		PrintUtil.print(test.findArray(new int[] { 13 }));
	}

	public int[] findArray(int[] pref) {
		for (int i = pref.length - 1; i > 0; i--) {
			pref[i] ^= pref[i - 1];
		}
		return pref;
	}

}

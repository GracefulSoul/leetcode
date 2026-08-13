package gracefulsoul.problems;

import java.util.TreeMap;

import gracefulsoul.util.PrintUtil;

public class LongestSubstringOfOneRepeatingCharacter {

	// https://leetcode.com/problems/longest-substring-of-one-repeating-character/submissions/2105407869/
	public static void main(String[] args) {
		LongestSubstringOfOneRepeatingCharacter test = new LongestSubstringOfOneRepeatingCharacter();
		PrintUtil.print(test.longestRepeating("babacc", "bcb", new int[] { 1, 3, 3 }));
		PrintUtil.print(test.longestRepeating("abyzz", "aa", new int[] { 2, 1 }));
	}

	public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		TreeMap<Integer, Integer> lengthMap = new TreeMap<>();
		TreeMap<Integer, Integer> spanMap = new TreeMap<>();
		for (int i = 0, j = 1; j <= length; j++) {
			if (j == length || charArray[i] != charArray[j]) {
				lengthMap.put(j - i, lengthMap.getOrDefault(j - i, 0) + 1);
				spanMap.put(i, j - 1);
				i = j;
			}
		}
		int[] result = new int[queryIndices.length];
		for (int i = 0; i < queryIndices.length; i++) {
			int j = queryIndices[i];
			if (charArray[j] != queryCharacters.charAt(i)) {
				int left = spanMap.floorKey(j);
				int right = spanMap.remove(left);
				int size = right - left + 1;
				if (lengthMap.get(size) == 1) { 
					lengthMap.remove(size);
				} else {
					lengthMap.put(size, lengthMap.get(size) - 1);
				}
				if (left < j) {
					spanMap.put(left, j - 1);
					lengthMap.put(j - left, lengthMap.getOrDefault(j - left, 0) + 1);
				}
				if (right > j) {
					spanMap.put(j + 1, right);
					lengthMap.put(right - j, lengthMap.getOrDefault(right - j, 0) + 1);
				}
				charArray[j] = queryCharacters.charAt(i);
				left = j;
				right = j;
				if (j > 0 && charArray[j] == charArray[j - 1]) {
					left = spanMap.floorKey(j);
					size = spanMap.remove(left) - left + 1;
					if (lengthMap.get(size) == 1) {
						lengthMap.remove(size);
					} else {
						lengthMap.put(size, lengthMap.get(size) - 1);
					}
				}
				if (j < length - 1 && charArray[j] == charArray[j + 1]) {
					int key = spanMap.ceilingKey(j);
					right = spanMap.remove(key);
					size = right - key + 1;
					if (lengthMap.get(size) == 1) {
						lengthMap.remove(size);
					} else {
						lengthMap.put(size, lengthMap.get(size) - 1);
					}
				}
				spanMap.put(left, right);
				lengthMap.put(right - left + 1, lengthMap.getOrDefault(right - left + 1, 0) + 1);
			}
			result[i] = lengthMap.lastKey();
		}
		return result;
	}

}

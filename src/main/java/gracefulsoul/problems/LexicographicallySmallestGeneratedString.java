package gracefulsoul.problems;

import java.util.Arrays;

public class LexicographicallySmallestGeneratedString {

	// https://leetcode.com/problems/lexicographically-smallest-generated-string/submissions/1964916611/
	public static void main(String[] args) {
		LexicographicallySmallestGeneratedString test = new LexicographicallySmallestGeneratedString();
		System.out.println(test.generateString("TFTF", "ab"));
		System.out.println(test.generateString("TFTF", "abc"));
		System.out.println(test.generateString("F", "d"));
	}

	public String generateString(String str1, String str2) {
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		int str1Length = str1CharArray.length;
		int str2Length = str2CharArray.length;
		int size = str1Length + str2Length - 1;
		char[] result = new char[size];
		Arrays.fill(result, '.');
		int[] array = this.caculate(str2);
		int index = -str2Length;
		for (int i = 0; i < str1Length; i++) {
			if (str1CharArray[i] != 'T') {
				continue;
			}
			int max = Math.max(index + str2Length - i, 0);
			if (max > 0 && array[str2Length - max] < max) {
				return "";
			}
			for (int j = max; j < str2Length; j++) {
				result[i + j] = str2CharArray[j];
			}
			index = i;
		}
		int[] position = new int[size];
		index = -1;
		for (int i = 0; i < size; i++) {
			if (result[i] == '.') {
				result[i] = 'a';
				index = i;
			}
			position[i] = index;
		}
		array = this.caculate(str2 + new String(result));
		for (int i = 0; i < str1Length; i++) {
			if (str1CharArray[i] != 'F') {
				continue;
			}
			if (array[str2Length + i] < str2Length) {
				continue;
			}
			int j = position[i + str2Length - 1];
			if (j < i) {
				return "";
			}
			result[j] = 'b';
			i = j;
		}
		return new String(result);
	}

	private int[] caculate(String str) {
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		int[] array = new int[length];
		int left = 0;
		int right = 0;
		for (int i = 1; i < length; i++) {
			if (i <= right) {
				array[i] = Math.min(array[i - left], right - i + 1);
			}
			while (i + array[i] < length && charArray[array[i]] == charArray[i + array[i]]) {
				left = i;
				right = i + array[i]++;
			}
		}
		array[0] = length;
		return array;
	}

}

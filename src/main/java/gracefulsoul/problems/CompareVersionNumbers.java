package gracefulsoul.problems;

public class CompareVersionNumbers {

	// https://leetcode.com/problems/compare-version-numbers/submissions/1780116664/
	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		System.out.println(test.compareVersion("1.01", "1.001"));
		System.out.println(test.compareVersion("1.0", "1.0.0"));
		System.out.println(test.compareVersion("0.1", "1.1"));
		System.out.println(test.compareVersion("1.0.1", "1"));
	}

	public int compareVersion(String version1, String version2) {
		int i = 0;
		int j = 0;
		char[] version1CharArray = version1.toCharArray();
		char[] version2CharArray = version2.toCharArray();
		int version1Length = version1CharArray.length;
		int version2Length = version2.length();
		while (i < version1Length || j < version2Length) {
			int num1 = 0;
			int num2 = 0;
			while (i < version1Length && version1CharArray[i] != '.') {
				num1 = num1 * 10 + (version1CharArray[i] - '0');
				i++;
			}
			while (j < version2Length && version2CharArray[j] != '.') {
				num2 = num2 * 10 + (version2CharArray[j] - '0');
				j++;
			}
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			} else {
				if (i < version1Length && version1CharArray[i] == '.') {
					i++;
				}
				if (j < version2Length && version2CharArray[j] == '.') {
					j++;
				}
			}
		}
		return 0;
	}

}

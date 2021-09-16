package gracefulsoul.problems;

public class CompareVersionNumbers {

	// https://leetcode.com/submissions/detail/555656630/
	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		System.out.println(test.compareVersion("1.01", "1.001"));
		System.out.println(test.compareVersion("1.0", "1.0.0"));
		System.out.println(test.compareVersion("0.1", "1.1"));
		System.out.println(test.compareVersion("1.0.1", "1"));
	}

	public int compareVersion(String version1, String version2) {
		String[] splitVersion1 = version1.split("\\.");
		String[] splitVersion2 = version2.split("\\.");
		for (int idx = 0; idx < splitVersion1.length || idx < splitVersion2.length; idx++) {
			int int1 = idx < splitVersion1.length ? Integer.parseInt(splitVersion1[idx]) : 0;
			int int2 = idx < splitVersion2.length ? Integer.parseInt(splitVersion2[idx]) : 0;
			if (int1 > int2) {
				return 1;
			} else if (int1 < int2) {
				return -1;
			}
		}
		return 0;
	}

}

package gracefulsoul.problems;

public class ImplementStrStr {

	// https://leetcode.com/submissions/detail/491571524/
	public static void main(String[] args) {
		ImplementStrStr test = new ImplementStrStr();
		System.out.println(test.strStr("hello", "ll"));
		System.out.println(test.strStr("aaaaa", "bba"));
		System.out.println(test.strStr("", ""));
	}

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (haystack.length() == 0) {
			return -1;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length()) {
				return -1;
			}
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				} else if (j == needle.length() - 1) {
					return i;
				}
			}
		}
		return -1;
	}

}

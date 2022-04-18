package gracefulsoul.problems;

public class RepeatedSubstringPattern {

	// https://leetcode.com/submissions/detail/682513546/
	public static void main(String[] args) {
		RepeatedSubstringPattern test = new RepeatedSubstringPattern();
		System.out.println(test.repeatedSubstringPattern("abab"));
		System.out.println(test.repeatedSubstringPattern("aba"));
		System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));
	}

	public boolean repeatedSubstringPattern(String s) {
		int length = s.length();
		for (int index = 1; index <= length / 2; index++) {
			if (length % index == 0) {
				String pattern = s.substring(0, index);
				boolean isRepeated = true;
				for (int curr = length - index; curr > 0; curr -= index) {
					if (!pattern.equals(s.substring(curr, curr + index))) {
						isRepeated = false;
						break;
					}
				}
				if (isRepeated) {
					return true;
				}
			}
		}
		return false;
	}

}

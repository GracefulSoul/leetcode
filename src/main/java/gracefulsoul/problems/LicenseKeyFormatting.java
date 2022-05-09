package gracefulsoul.problems;

public class LicenseKeyFormatting {

	// https://leetcode.com/submissions/detail/695887383/
	public static void main(String[] args) {
		LicenseKeyFormatting test = new LicenseKeyFormatting();
		System.out.println(test.licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(test.licenseKeyFormatting("2-5g-3-J", 2));
	}

	public String licenseKeyFormatting(String s, int k) {
		char[] chars = new char[s.length() * 2];
		int count = 0;
		int index = chars.length;
		for (int idx = s.length() - 1; idx >= 0; idx--) {
			char c = s.charAt(idx);
			if (c == '-') {
				continue;
			}
			if (count == k) {
				chars[--index] = '-';
				count = 0;
			}
			chars[--index] = Character.toUpperCase(c);
			count++;
		}
		return String.valueOf(chars, index, chars.length - index);
	}

}

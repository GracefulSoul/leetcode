package gracefulsoul.problems;

public class GreatestCommonDivisorOfStrings {

	// https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/1220962021/
	public static void main(String[] args) {
		GreatestCommonDivisorOfStrings test = new GreatestCommonDivisorOfStrings();
		System.out.println(test.gcdOfStrings("ABCABC", "ABC"));
		System.out.println(test.gcdOfStrings("ABABAB", "ABAB"));
		System.out.println(test.gcdOfStrings("LEET", "CODE"));
	}

	public String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		} else {
			return str2.substring(0, this.getGcd(str1.length(), str2.length()));
		}
	}

	private int getGcd(int a, int b) {
		return b == 0 ? a : this.getGcd(b, a % b);
	}

}

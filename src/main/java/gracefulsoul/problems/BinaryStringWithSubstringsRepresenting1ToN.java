package gracefulsoul.problems;

public class BinaryStringWithSubstringsRepresenting1ToN {

	// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/submissions/1130170850/
	public static void main(String[] args) {
		BinaryStringWithSubstringsRepresenting1ToN test = new BinaryStringWithSubstringsRepresenting1ToN();
		System.out.println(test.queryString("0110", 3));
		System.out.println(test.queryString("0110", 4));
	}

	public boolean queryString(String s, int n) {
		for (int i = n; i > n / 2; i--) {
			if (!s.contains(Integer.toBinaryString(i))) {
				return false;
			}
		}
		return true;
	}

}

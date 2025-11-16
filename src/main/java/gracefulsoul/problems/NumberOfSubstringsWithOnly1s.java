package gracefulsoul.problems;

public class NumberOfSubstringsWithOnly1s {

	// https://leetcode.com/problems/number-of-substrings-with-only-1s/submissions/1831281919/
	public static void main(String[] args) {
		NumberOfSubstringsWithOnly1s test = new NumberOfSubstringsWithOnly1s();
		System.out.println(test.numSub("0110111"));
		System.out.println(test.numSub("101"));
		System.out.println(test.numSub("111111"));
	}

	public int numSub(String s) {
		int result = 0;
		int count = 0;
		int mod = 1000000007;
		for (char c : s.toCharArray()) {
			if (c == '1') {
				count++;
				result = (result + count) % mod;
			} else {
				count = 0;
			}
		}
		return result;
	}

}

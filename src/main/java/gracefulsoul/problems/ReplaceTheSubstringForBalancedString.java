package gracefulsoul.problems;

public class ReplaceTheSubstringForBalancedString {

	// https://leetcode.com/problems/replace-the-substring-for-balanced-string/submissions/1551435925/
	public static void main(String[] args) {
		ReplaceTheSubstringForBalancedString test = new ReplaceTheSubstringForBalancedString();
		System.out.println(test.balancedString("QWER"));
		System.out.println(test.balancedString("QQWE"));
		System.out.println(test.balancedString("QQQW"));
	}

	public int balancedString(String s) {
		int[] counts = new int[128];
		for (char c : s.toCharArray()) {
			counts[c]++;
		}
		int length = s.length();
		int max = length / 4;
		int result = length;
		int i = 0;
		for (int j = 0; j < length; j++) {
			counts[s.charAt(j)]--;
			while (i < length && counts['Q'] <= max && counts['W'] <= max && counts['E'] <= max && counts['R'] <= max) {
				result = Math.min(result, j - i + 1);
				counts[s.charAt(i++)]++;
			}
		}
		return result;
	}

}

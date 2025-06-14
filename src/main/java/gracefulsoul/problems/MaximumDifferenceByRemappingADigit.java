package gracefulsoul.problems;

public class MaximumDifferenceByRemappingADigit {

	// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/submissions/1663575192/
	public static void main(String[] args) {
		MaximumDifferenceByRemappingADigit test = new MaximumDifferenceByRemappingADigit();
		System.out.println(test.minMaxDifference(11891));
		System.out.println(test.minMaxDifference(90));
	}

	public int minMaxDifference(int num) {
		String str = String.valueOf(num);
		char[] max = str.toCharArray();
		char[] min = str.toCharArray();
		char replace = ' ';
		for (char c : max) {
			if (c != '9') {
				replace = c;
				break;
			}
		}
		for (int i = 0; i < max.length; i++) {
			if (max[i] == replace) {
				max[i] = '9';
			}
		}
		replace = min[0];
		for (int i = 0; i < min.length; i++) {
			if (min[i] == replace) {
				min[i] = '0';
			}
		}
		return Integer.parseInt(String.valueOf(max)) - Integer.parseInt(String.valueOf(min));
	}

}

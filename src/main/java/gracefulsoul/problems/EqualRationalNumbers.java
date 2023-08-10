package gracefulsoul.problems;

public class EqualRationalNumbers {

	// https://leetcode.com/problems/equal-rational-numbers/submissions/1017313092/
	public static void main(String[] args) {
		EqualRationalNumbers test = new EqualRationalNumbers();
		System.out.println(test.isRationalEqual("0.(52)", "0.5(25)"));
		System.out.println(test.isRationalEqual("0.1666(6)", "0.166(66)"));
		System.out.println(test.isRationalEqual("0.9(9)", "1."));
	}

	public boolean isRationalEqual(String s, String t) {
		return this.parse(s) == this.parse(t);
	}

	private double parse(String str) {
		int index = str.indexOf('(');
		if (index > 0) {
			String base = str.substring(0, index);
			String decimal = str.substring(index + 1, str.length() - 1);
			for (int j = 1; j < 18; j++) {
				base += decimal;
			}
			return Double.valueOf(base);
		} else {
			return Double.valueOf(str);
		}
	}

}

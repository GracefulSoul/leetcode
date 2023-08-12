package gracefulsoul.problems;

public class EqualRationalNumbers {

	// https://leetcode.com/problems/equal-rational-numbers/submissions/1017318458/
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
			StringBuilder base = new StringBuilder(str.substring(0, index));
			String num = str.substring(index + 1, str.length() - 1);
			for (int i = 1; i < 18; i++) {
				base.append(num);
			}
			return Double.valueOf(base.toString());
		} else {
			return Double.valueOf(str);
		}
	}

}

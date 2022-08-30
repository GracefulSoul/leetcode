package gracefulsoul.problems;

public class SolveTheEquation {

	// https://leetcode.com/submissions/detail/787084478/
	public static void main(String[] args) {
		SolveTheEquation test = new SolveTheEquation();
		System.out.println(test.solveEquation("x+5-3+x=6+x-2"));
		System.out.println(test.solveEquation("x=x"));
		System.out.println(test.solveEquation("2x=x"));
	}

	public String solveEquation(String equation) {
		String[] split = equation.split("=");
		int[] values = new int[4];
		this.caculate(split[0], values, 0);
		this.caculate(split[1], values, 2);
		int left = values[0] - values[2];
		int right = values[3] - values[1];
		if (left == 0 && right == 0) {
			return "Infinite solutions";
		} else if (left == 0) {
			return "No solution";
		} else {
			return new StringBuilder("x=").append(right / left).toString();
		}
	}

	private void caculate(String s, int[] values, int index) {
		int sign = 1;
		int value = 0;
		char prev = '1';
		for (char c : s.toCharArray()) {
			if (c == 'x') {
				if (value == 0 && (prev != '0')) {
					value = 1;
				}
				values[index] += sign * value;
				value = 0;
			} else if (c == '+' || c == '-') {
				values[index + 1] += sign * value;
				value = 0;
				sign = (c == '+') ? 1 : -1;
			} else {
				value = (value * 10) + (c - '0');
			}
			prev = c;
		}
		values[index + 1] += sign * value;
	}

}

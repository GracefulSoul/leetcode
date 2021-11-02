package gracefulsoul.problems;

public class BasicCalculatorII {

	// https://leetcode.com/submissions/detail/580763966/
	public static void main(String[] args) {
		BasicCalculatorII test = new BasicCalculatorII();
		System.out.println(test.calculate("3+2*2"));
		System.out.println(test.calculate(" 3/2 "));
		System.out.println(test.calculate(" 3+5 / 2 "));
	}

	public int calculate(String s) {
		int sum = 0;
		int pre = 0;
		char sign = '+';
		for (int idx = 0; idx < s.length(); idx++) {
			char c = s.charAt(idx);
			if (c == ' ') {
				continue;
			} else if (Character.isDigit(c)) {
				int num = c - '0';
				while (idx < s.length() - 1 && Character.isDigit(s.charAt(idx + 1))) {
					num = num * 10 + (s.charAt(idx + 1) - '0');
					idx++;
				}
				switch (sign) {
					case '+':
						sum += pre;
						pre = num;
						break;
					case '-':
						sum += pre;
						pre = -num;
						break;
					case '*':
						pre *= num;
						break;
					case '/':
						pre /= num;
						break;
				}
			} else {
				sign = c;
			}
		}
		return sum + pre;
	}

}

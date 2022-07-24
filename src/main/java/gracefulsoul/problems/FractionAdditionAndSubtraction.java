package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction {

	public static void main(String[] args) {
		FractionAdditionAndSubtraction test = new FractionAdditionAndSubtraction();
		System.out.println(test.fractionAddition("-1/2+1/2"));
		System.out.println(test.fractionAddition("-1/2+1/2+1/3"));
		System.out.println(test.fractionAddition("1/3-1/2"));
	}

	public String fractionAddition(String expression) {
		List<Character> sign = new ArrayList<>();
		for (char c : expression.toCharArray()) {
			if (c == '+' || c == '-') {
				sign.add(c);
			}
		}
		List<Integer> num = new ArrayList<>();
		List<Integer> den = new ArrayList<>();
		for (String sub : expression.split("\\+")) {
			for (String subsub : sub.split("-")) {
				if (subsub.length() > 0) {
					String[] fraction = subsub.split("/");
					num.add(Integer.parseInt(fraction[0]));
					den.add(Integer.parseInt(fraction[1]));
				}
			}
		}
		if (expression.charAt(0) == '-')
			num.set(0, -num.get(0));
		int lcm = 1;
		for (int x : den) {
			lcm = this.lcm(lcm, x);
		}

		int res = lcm / den.get(0) * num.get(0);
		for (int i = 1; i < num.size(); i++) {
			if (sign.get(i - 1) == '+')
				res += lcm / den.get(i) * num.get(i);
			else
				res -= lcm / den.get(i) * num.get(i);
		}
		int g = this.gcd(Math.abs(res), Math.abs(lcm));
		return (res / g) + "/" + (lcm / g);
	}

	public int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

}

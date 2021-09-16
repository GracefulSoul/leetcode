package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	// https://leetcode.com/submissions/detail/556170526/
	public static void main(String[] args) {
		FractionToRecurringDecimal test = new FractionToRecurringDecimal();
		System.out.println(test.fractionToDecimal(1, 2));
		System.out.println(test.fractionToDecimal(2, 1));
		System.out.println(test.fractionToDecimal(2, 3));
		System.out.println(test.fractionToDecimal(4, 333));
		System.out.println(test.fractionToDecimal(1, 5));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			result.append("-");
		}
		long numeratorLong = Math.abs((long) numerator);
		long denominatorLong = Math.abs((long) denominator);
		result.append(numeratorLong / denominatorLong);
		long remainder = numeratorLong % denominatorLong;
		if (remainder == 0) {
			return result.toString();
		}
		result.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (remainder != 0) {
			if (!map.containsKey(remainder)) {
				map.put(remainder, result.length());
			} else {
				result.insert(map.get(remainder), "(");
				result.append(")");
				return result.toString();
			}
			remainder *= 10;
			result.append(remainder / denominatorLong);
			remainder %= denominatorLong;
		}
		return result.toString();
	}

}

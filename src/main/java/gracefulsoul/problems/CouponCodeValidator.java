package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponCodeValidator {

	// https://leetcode.com/problems/coupon-code-validator/submissions/1854237210/
	public static void main(String[] args) {
		CouponCodeValidator test = new CouponCodeValidator();
		System.out.println(test.validateCoupons(
				new String[] { "SAVE20", "", "PHARMA5", "SAVE@20" },
				new String[] { "restaurant", "grocery", "pharmacy", "restaurant" },
				new boolean[] { true, true, true, true }));
		System.out.println(test.validateCoupons(
				new String[] { "GROCERY15", "ELECTRONICS_50", "DISCOUNT10" },
				new String[] { "grocery", "electronics", "invalid" },
				new boolean[] { false, true, true }));
	}

	public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
		Map<String, Integer> priority = new HashMap<>();
		priority.put("electronics", 0);
		priority.put("grocery", 1);
		priority.put("pharmacy", 2);
		priority.put("restaurant", 3);
		List<Coupon> list = new ArrayList<>();
		for (int i = 0; i < code.length; i++) {
			if (isActive[i] && priority.containsKey(businessLine[i]) && this.isValid(code[i].toCharArray())) {
				list.add(new Coupon(priority.get(businessLine[i]), code[i]));
			}
		}
		Collections.sort(list, (a, b) -> {
			if (a.priority != b.priority) {
				return a.priority - b.priority;
			} else {
				return a.code.compareTo(b.code);
			}
		});
		List<String> result = new ArrayList<>();
		for (Coupon coupon : list) {
			result.add(coupon.code);
		}
		return result;
	}

	private boolean isValid(char[] charArray) {
		if (charArray.length == 0) {
			return false;
		} else {
			for (char c :charArray) {
				if (!Character.isLetterOrDigit(c) && c != '_')
					return false;
			}
			return true;
		}
	}

	private class Coupon {
		private int priority;
		private String code;
		Coupon(int priority, String code) {
			this.priority = priority;
			this.code = code;
		}
	}

}

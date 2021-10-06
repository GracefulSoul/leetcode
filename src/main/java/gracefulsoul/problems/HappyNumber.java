package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	// https://leetcode.com/submissions/detail/566500165/
	public static void main(String[] args) {
		HappyNumber test = new HappyNumber();
		System.out.println(test.isHappy(19));
		System.out.println(test.isHappy(2));
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		while (set.add(n)) {
			sum = 0;
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1) {
				return true;
			} else {
				n = sum;
			}
		}
		return false;
	}

}

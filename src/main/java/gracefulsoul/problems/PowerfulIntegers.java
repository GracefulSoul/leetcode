package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

	// https://leetcode.com/problems/powerful-integers/submissions/1014549929/
	public static void main(String[] args) {
		PowerfulIntegers test = new PowerfulIntegers();
		System.out.println(test.powerfulIntegers(2, 3, 10));
		System.out.println(test.powerfulIntegers(3, 5, 15));
	}

	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> result = new HashSet<>();
		for (int i = 1; i < bound; i *= x) {
			for (int j = 1; i + j <= bound; j *= y) {
				result.add(i + j);
				if (y == 1) {
					break;
				}
			}
			if (x == 1) {
				break;
			}
		}
		return new ArrayList<>(result);
	}

}

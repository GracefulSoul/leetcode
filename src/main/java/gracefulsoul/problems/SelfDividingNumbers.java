package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	// https://leetcode.com/submissions/detail/843824546/
	public static void main(String[] args) {
		SelfDividingNumbers test = new SelfDividingNumbers();
		System.out.println(test.selfDividingNumbers(1, 22));
		System.out.println(test.selfDividingNumbers(47, 85));
	}

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int idx = left; idx <= right; idx++) {
			int num = idx;
			boolean valid = true;
			while (num > 0) {
				int remain = num % 10;
				if (remain == 0 || idx % remain != 0) {
					valid = false;
					break;
				}
				num /= 10;
			}
			if (valid) {
				result.add(idx);
			}
		}
		return result;
	}

}

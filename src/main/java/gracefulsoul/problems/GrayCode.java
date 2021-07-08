package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	// https://leetcode.com/submissions/detail/519088732/
	public static void main(String[] args) {
		GrayCode test = new GrayCode();
		System.out.println(test.grayCode(2));
		System.out.println(test.grayCode(1));
	}

	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		int increase = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = result.size(); j > 0; j--) {
				result.add(increase + result.get(j - 1));
			}
			increase *= 2;
		}
		return result;
	}

}

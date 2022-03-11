package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	// https://leetcode.com/submissions/detail/657577727/
	public static void main(String[] args) {
		FizzBuzz test = new FizzBuzz();
		System.out.println(test.fizzBuzz(3));
		System.out.println(test.fizzBuzz(5));
		System.out.println(test.fizzBuzz(15));
	}

	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int idx = 1; idx <= n; idx++) {
			if (idx % 15 == 0) {
				result.add("FizzBuzz");
			} else if (idx % 3 == 0) {
				result.add("Fizz");
			} else if (idx % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(idx));
			}
		}
		return result;
	}

}

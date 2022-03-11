package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	// https://leetcode.com/submissions/detail/657576127/
	public static void main(String[] args) {
		FizzBuzz test = new FizzBuzz();
		System.out.println(test.fizzBuzz(3));
		System.out.println(test.fizzBuzz(5));
		System.out.println(test.fizzBuzz(15));
	}

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for (int idx = 1; idx <= n; idx++) {
			if (idx % 15 == 0) {
				list.add("FizzBuzz");
			} else if (idx % 3 == 0) {
				list.add("Fizz");
			} else if (idx % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(String.valueOf(idx));
			}
		}
		return list;
	}

}

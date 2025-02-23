package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {

	// https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/submissions/1552243369/
	public static void main(String[] args) {
		FindPositiveIntegerSolutionForAGivenEquation test = new FindPositiveIntegerSolutionForAGivenEquation();
		System.out.println(test.findSolution(new CustomPlusFunction(), 5));
		System.out.println(test.findSolution(new CustomMultiplyFunction(), 5));
	}

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> result = new ArrayList<>();
		int x = 1;
		int y = 1000;
		while (x <= 1000 && y > 0) {
			int v = customfunction.f(x, y);
			if (v < z) {
				x++;
			} else if (v > z) {
				y--;
			} else {
				result.add(Arrays.asList(x++, y--));
			}
		}
		return result;
	}

}

interface CustomFunction {

	public int f(int x, int y);

}

class CustomPlusFunction implements CustomFunction {

	public int f(int x, int y) {
		return x + y;
	}

}

class CustomMultiplyFunction implements CustomFunction {

	public int f(int x, int y) {
		return x * y;
	}

}

package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfBurgersWithNoWasteOfIngredients {

	// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/submissions/1708460174/
	public static void main(String[] args) {
		NumberOfBurgersWithNoWasteOfIngredients test = new NumberOfBurgersWithNoWasteOfIngredients();
		System.out.println(test.numOfBurgers(16, 7));
		System.out.println(test.numOfBurgers(17, 4));
		System.out.println(test.numOfBurgers(4, 17));
	}

	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		int doubleJumbo = tomatoSlices - (2 * cheeseSlices);
		int jumbo = doubleJumbo / 2;
		int small = cheeseSlices - jumbo;
		if (0 <= jumbo && doubleJumbo % 2 == 0 && 0 <= small) {
			return Arrays.asList(jumbo, small);
		} else {
			return new ArrayList<>();
		}
	}

}

package gracefulsoul.problems;

import java.util.Arrays;

public class BoatsToSavePeople {

	// https://leetcode.com/problems/boats-to-save-people/submissions/920692308/
	public static void main(String[] args) {
		BoatsToSavePeople test = new BoatsToSavePeople();
		System.out.println(test.numRescueBoats(new int[] { 1, 2 }, 3));
		System.out.println(test.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3));
		System.out.println(test.numRescueBoats(new int[] { 3, 5, 3, 4 }, 3));
	}

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		int result = 0;
		while (i <= j) {
			result++;
			if (people[i] + people[j--] <= limit) {
				i++;
			}
		}
		return result;
	}

}

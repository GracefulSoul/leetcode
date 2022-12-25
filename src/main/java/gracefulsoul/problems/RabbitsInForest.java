package gracefulsoul.problems;

public class RabbitsInForest {

	// https://leetcode.com/problems/rabbits-in-forest/submissions/865001680/
	public static void main(String[] args) {
		RabbitsInForest test = new RabbitsInForest();
		System.out.println(test.numRabbits(new int[] { 1, 1, 2 }));
		System.out.println(test.numRabbits(new int[] { 10, 10, 10 }));
	}

	public int numRabbits(int[] answers) {
		int result = 0;
		int[] count = new int[1000];
		for (int answer : answers) {
			if (count[answer] % (answer + 1) == 0) {
				result += answer + 1;
			}
			count[answer]++;
		}
		return result;
	}

}

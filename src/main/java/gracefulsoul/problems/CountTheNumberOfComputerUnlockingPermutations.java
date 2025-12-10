package gracefulsoul.problems;

public class CountTheNumberOfComputerUnlockingPermutations {

	// https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/submissions/1851998637/
	public static void main(String[] args) {
		CountTheNumberOfComputerUnlockingPermutations test = new CountTheNumberOfComputerUnlockingPermutations();
		System.out.println(test.countPermutations(new int[] { 1, 2, 3 }));
		System.out.println(test.countPermutations(new int[] { 3, 3, 3, 4, 4, 4 }));
	}

	public int countPermutations(int[] comp) {
		int length = comp.length;
		int first = comp[0];
		for (int i = 1; i < length; i++) {
			if (comp[i] <= first) {
				return 0;
			}
		}
		long result = 1;
		for (int i = 2; i < length; i++) {
			result = (result * i) % 1000000007;
		}
		return (int) result;
	}

}

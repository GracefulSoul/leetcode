package gracefulsoul.problems;

public class CheckIfStringsCanBeMadeEqualWithOperationsII {

	// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/submissions/1963690666/
	public static void main(String[] args) {
		CheckIfStringsCanBeMadeEqualWithOperationsII test = new CheckIfStringsCanBeMadeEqualWithOperationsII();
		System.out.println(test.checkStrings("abcdba", "cabdab"));
		System.out.println(test.checkStrings("abe", "bea"));
	}

	public boolean checkStrings(String s1, String s2) {
		int[] counts = new int[52];
		for (int i = 0; i < s1.length(); i++) {
			int offset = (i & 1) * 26;
			counts[(s1.charAt(i) - 'a') + offset]++;
			counts[(s2.charAt(i) - 'a') + offset]--;
		}
		for (int i = 0; i < 52; i++) {
			if (counts[i] != 0) {
				return false;
			}
		}
		return true;
	}

}

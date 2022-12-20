package gracefulsoul.problems;

public class JewelsAndStones {

	// https://leetcode.com/problems/jewels-and-stones/submissions/862491355/
	public static void main(String[] args) {
		JewelsAndStones test = new JewelsAndStones();
		System.out.println(test.numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(test.numJewelsInStones("z", "ZZ"));
	}

	public int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (jewels.indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}

}

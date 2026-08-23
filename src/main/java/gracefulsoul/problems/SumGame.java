package gracefulsoul.problems;

public class SumGame {

	// https://leetcode.com/problems/sum-game/submissions/2116687490/
	public static void main(String[] args) {
		SumGame test = new SumGame();
		System.out.println(test.sumGame("5023"));
		System.out.println(test.sumGame("25??"));
		System.out.println(test.sumGame("?3295???"));
	}

	public boolean sumGame(String num) {
		char[] charArray = num.toCharArray();
		int length = charArray.length;
		double result = 0;
		for (int i = 0; i < length; i++) {
			char c = charArray[i];
			result += (i < length / 2 ? 1 : -1) * (c == '?' ? 4.5 : c - '0');
		}
		return result != 0;
	}

}

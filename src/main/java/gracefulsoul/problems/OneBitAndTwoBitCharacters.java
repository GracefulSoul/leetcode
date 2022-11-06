package gracefulsoul.problems;

public class OneBitAndTwoBitCharacters {

	// https://leetcode.com/submissions/detail/837664588/
	public static void main(String[] args) {
		OneBitAndTwoBitCharacters test = new OneBitAndTwoBitCharacters();
		System.out.println(test.isOneBitCharacter(new int[] { 1, 0, 0 }));
		System.out.println(test.isOneBitCharacter(new int[] { 1, 1, 1, 0 }));
	}

	public boolean isOneBitCharacter(int[] bits) {
		int bit = 0;
		for (int idx = bits.length - 2; idx >= 0 && bits[idx] != 0; idx--) {
			bit++;
		}
		return bit % 2 == 0;
	}

}

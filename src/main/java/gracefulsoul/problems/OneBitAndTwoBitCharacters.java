package gracefulsoul.problems;

public class OneBitAndTwoBitCharacters {

	// https://leetcode.com/submissions/detail/837659403/
	public static void main(String[] args) {
		OneBitAndTwoBitCharacters test = new OneBitAndTwoBitCharacters();
		System.out.println(test.isOneBitCharacter(new int[] { 1, 0, 0 }));
		System.out.println(test.isOneBitCharacter(new int[] { 1, 1, 1, 0 }));
	}

	public boolean isOneBitCharacter(int[] bits) {
		int bit = 0;
		for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
			bit++;
		}
		return bit % 2 <= 0;
	}

}

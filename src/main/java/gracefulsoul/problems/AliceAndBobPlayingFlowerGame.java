package gracefulsoul.problems;

public class AliceAndBobPlayingFlowerGame {

	// https://leetcode.com/problems/alice-and-bob-playing-flower-game/submissions/1752289442/
	public static void main(String[] args) {
		AliceAndBobPlayingFlowerGame test = new AliceAndBobPlayingFlowerGame();
		System.out.println(test.flowerGame(3, 2));
		System.out.println(test.flowerGame(1, 1));
	}

	public long flowerGame(int n, int m) {
		return (1L * n * m) / 2;
	}

}
